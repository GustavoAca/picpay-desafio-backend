package gustavo.acacio.desafiopicpay.picpay.service.wallet;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.CreateWalletDto;
import gustavo.acacio.desafiopicpay.picpay.core.BaseService;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;

public interface WalletService extends BaseService<Wallet, Long> {
    Wallet create(CreateWalletDto dto);
}
