package gustavo.acacio.desafiopicpay.picpay.repository;

import gustavo.acacio.desafiopicpay.picpay.core.BaseRepository;
import gustavo.acacio.desafiopicpay.picpay.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, UUID>, BaseRepository<Transfer, UUID> {
}
