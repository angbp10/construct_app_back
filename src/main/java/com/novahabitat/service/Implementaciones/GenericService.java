package com.novahabitat.service.Implementaciones;

import com.novahabitat.exception.ModelNotFoundException;
import com.novahabitat.Repository.IGenericRepository;
import com.novahabitat.service.ICustomerService;
import com.novahabitat.service.IGenericService;

import java.util.List;

public abstract class GenericService<T,ID> implements IGenericService<T,ID> {
    protected abstract IGenericRepository<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        //API REFLEXION
        //EVALUAR ID
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        //return getRepo().findById(id).orElse(null);
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("No se encontro el ID" + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
