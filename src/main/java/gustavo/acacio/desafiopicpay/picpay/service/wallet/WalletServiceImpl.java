package gustavo.acacio.desafiopicpay.picpay.service.wallet;

import gustavo.acacio.desafiopicpay.picpay.controller.dto.CreateWalletDto;
import gustavo.acacio.desafiopicpay.picpay.core.AbstractService;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;
import gustavo.acacio.desafiopicpay.picpay.exception.WalletDataAlreadyExistsException;
import gustavo.acacio.desafiopicpay.picpay.exception.WalletNotFoundException;
import gustavo.acacio.desafiopicpay.picpay.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl extends AbstractService<Wallet, Long, WalletRepository> implements WalletService {

    protected WalletServiceImpl(WalletRepository repo) {
        super(repo);
    }

    @Override
    public Wallet create(CreateWalletDto dto) {
        var wallet = repo.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (wallet.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj Already exists");
        }
        return repo.save(dto.toWallet());
    }
}
