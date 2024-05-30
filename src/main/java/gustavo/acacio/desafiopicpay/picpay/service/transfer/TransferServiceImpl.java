package gustavo.acacio.desafiopicpay.picpay.service.transfer;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.TransferDto;
import gustavo.acacio.desafiopicpay.picpay.core.AbstractService;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;
import gustavo.acacio.desafiopicpay.picpay.exception.InsufficientBalanceException;
import gustavo.acacio.desafiopicpay.picpay.exception.TransferNotAllowedForTypeException;
import gustavo.acacio.desafiopicpay.picpay.exception.TransferNotAuthorizedException;
import gustavo.acacio.desafiopicpay.picpay.repository.TransferRepository;
import gustavo.acacio.desafiopicpay.picpay.repository.WalletRepository;
import gustavo.acacio.desafiopicpay.picpay.service.authorization.AuthorizationService;
import gustavo.acacio.desafiopicpay.picpay.service.notification.NotificationService;
import gustavo.acacio.desafiopicpay.picpay.service.wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class TransferServiceImpl extends AbstractService<Transfer, UUID, TransferRepository> implements TransferService {

    protected TransferServiceImpl(TransferRepository repo) {
        super(repo);
    }
}
