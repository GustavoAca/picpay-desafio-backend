package gustavo.acacio.desafiopicpay.picpay.service.wallettype;

import gustavo.acacio.desafiopicpay.picpay.core.AbstractService;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;
import gustavo.acacio.desafiopicpay.picpay.entity.WalletType;
import gustavo.acacio.desafiopicpay.picpay.repository.WalletRepository;
import gustavo.acacio.desafiopicpay.picpay.repository.WalletTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletTypeServiceImpl extends AbstractService<WalletType, Long, WalletTypeRepository> implements WalletTypeService {

    public WalletTypeServiceImpl(WalletTypeRepository repo) {
        super(repo);
    }
}
