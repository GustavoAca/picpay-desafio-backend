package gustavo.acacio.desafiopicpay.picpay.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

public interface BaseRepository<E extends BaseEntity, K extends Serializable> extends JpaRepository<E, K>, JpaSpecificationExecutor<E> {
}
