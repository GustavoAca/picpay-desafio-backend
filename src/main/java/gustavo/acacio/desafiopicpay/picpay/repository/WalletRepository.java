package gustavo.acacio.desafiopicpay.picpay.repository;

import gustavo.acacio.desafiopicpay.picpay.core.BaseRepository;
import gustavo.acacio.desafiopicpay.picpay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>, BaseRepository<Wallet, Long> {
    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
