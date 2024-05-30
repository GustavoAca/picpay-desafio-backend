package gustavo.acacio.desafiopicpay.picpay.core;

import gustavo.acacio.desafiopicpay.picpay.entity.WalletType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity, K extends Serializable> {

    T salvar(T entity);
    Page<T> listarPagina(Pageable pageable);
    Optional<T> buscarPorId(K id);
}
