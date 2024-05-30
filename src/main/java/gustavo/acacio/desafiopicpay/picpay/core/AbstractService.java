package gustavo.acacio.desafiopicpay.picpay.core;

import gustavo.acacio.desafiopicpay.picpay.entity.WalletType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public class AbstractService<E extends BaseEntity, K extends Serializable, R extends BaseRepository<E, K>> implements BaseService<E, K> {

    protected R repo;

    protected AbstractService(R repo){
        this.repo = repo;
    }
    public E salvar(E entity){
        return this.repo.save(entity);
    }

    @Override
    public Page<E> listarPagina(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<E> buscarPorId(K id) {
        return repo.findById(id);
    }
}
