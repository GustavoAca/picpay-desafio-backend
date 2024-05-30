package gustavo.acacio.desafiopicpay.picpay.controller.dto;

import gustavo.acacio.desafiopicpay.picpay.entity.WalletType;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(@NotBlank String fullName,
                              @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull WalletType.Value walletType) {

    public Wallet toWallet() {
        return Wallet.builder()
                .fullname(fullName)
                .cpfCnpj(cpfCnpj)
                .email(email)
                .password(password)
                .walletType(walletType.get())
                .build();
    }
}
