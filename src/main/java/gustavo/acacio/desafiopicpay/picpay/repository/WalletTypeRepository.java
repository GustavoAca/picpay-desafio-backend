package gustavo.acacio.desafiopicpay.picpay.repository;

import gustavo.acacio.desafiopicpay.picpay.core.BaseRepository;
import gustavo.acacio.desafiopicpay.picpay.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long>, BaseRepository<WalletType, Long> {
}
