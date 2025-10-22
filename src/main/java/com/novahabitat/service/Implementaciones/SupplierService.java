package com.novahabitat.service.Implementaciones;

import com.novahabitat.Model.Supplier;
import com.novahabitat.Repository.IGenericRepository;
import com.novahabitat.Repository.ISupplierRepository;
import com.novahabitat.service.ISupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService extends GenericService<Supplier, Integer> implements ISupplierService {
    //@Autowired
    private final ISupplierRepository repo;


    @Override
    protected IGenericRepository<Supplier, Integer> getRepo() {
        return repo;
    }
}
