package gustavo.acacio.desafiopicpay.picpay.controller;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.CreateWalletDto;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;
import gustavo.acacio.desafiopicpay.picpay.service.wallet.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private final WalletService walletService;
    @Autowired

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto dto) {
        return ResponseEntity.ok(walletService.create(dto));
    }

}
