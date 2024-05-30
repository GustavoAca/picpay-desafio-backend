package gustavo.acacio.desafiopicpay.picpay.config;

import gustavo.acacio.desafiopicpay.picpay.entity.WalletType;
import gustavo.acacio.desafiopicpay.picpay.service.wallettype.WalletTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {
    private final WalletTypeService walletTypeService;

    public DataLoader(WalletTypeService walletTypeService) {
        this.walletTypeService = walletTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Value.values())
                .forEach(walletType -> walletTypeService.salvar(walletType.get()));
    }
}
