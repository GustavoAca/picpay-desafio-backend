package gustavo.acacio.desafiopicpay.picpay.service.transfer;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.TransferDto;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;
import gustavo.acacio.desafiopicpay.picpay.exception.InsufficientBalanceException;
import gustavo.acacio.desafiopicpay.picpay.exception.TransferNotAllowedForTypeException;
import gustavo.acacio.desafiopicpay.picpay.exception.TransferNotAuthorizedException;
import gustavo.acacio.desafiopicpay.picpay.exception.WalletNotFoundException;
import gustavo.acacio.desafiopicpay.picpay.service.authorization.AuthorizationService;
import gustavo.acacio.desafiopicpay.picpay.service.notification.NotificationService;
import gustavo.acacio.desafiopicpay.picpay.service.wallet.WalletService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Component
public class TransferComponent {

    private final NotificationService notificationService;
    private final AuthorizationService authorizationService;
    private final WalletService walletService;
    private final TransferService transferService;

    @Autowired
    public TransferComponent(NotificationService notificationService,
                             AuthorizationService authorizationService,
                             WalletService walletService,
                             TransferService transferService) {
        this.notificationService = notificationService;
        this.authorizationService = authorizationService;
        this.walletService = walletService;
        this.transferService = transferService;
    }

    @Transactional
    public Transfer transfer(TransferDto transferDto) {
        var sender = buscarPorId(transferDto.payee());
        var receiver = buscarPorId(transferDto.payer());
        validateTransfer(transferDto, sender);
        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());
        var transfer = criarTransferencia(sender, receiver, transferDto.value());
        salvarAlteracao(sender);
        salvarAlteracao(receiver);
        var transferResult = transferService.salvar(transfer);
        enviarNotificacao(transferResult);
        return transferResult;
    }

    private Wallet buscarPorId(Long id) {
        return walletService.buscarPorId(id)
                .orElseThrow(() -> new WalletNotFoundException(id));
    }

    private void validateTransfer(TransferDto transfer, Wallet sender) {
        if (!sender.isTransferAllowedForWalletType())
            throw new TransferNotAllowedForTypeException();

        if (!sender.isBalancerEqualOrGreatherThan(transfer.value()))
            throw new InsufficientBalanceException();

        if (!authorizationService.isAuthorized(transfer))
            throw new TransferNotAuthorizedException();
    }

    private Transfer criarTransferencia(Wallet sender, Wallet receiver, BigDecimal value) {
        return new Transfer(sender, receiver, value);
    }

    private void salvarAlteracao(Wallet wallet) {
        walletService.salvar(wallet);
    }

    private void enviarNotificacao(Transfer transfer) {
        CompletableFuture.runAsync(() -> notificationService.sendNotification(transfer));
    }
}
