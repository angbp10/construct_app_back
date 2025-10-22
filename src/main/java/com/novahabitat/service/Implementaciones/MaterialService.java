package com.novahabitat.service.Implementaciones;

import lombok.RequiredArgsConstructor;
import com.novahabitat.Model.Material;
import com.novahabitat.Repository.IMaterialRepository;
import com.novahabitat.Repository.IGenericRepository;
import com.novahabitat.service.IMaterialService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialService extends GenericService<Material,Integer> implements IMaterialService {
    private final IMaterialRepository repo;

    @Override
    protected IGenericRepository<Material,Integer> getRepo() {
        return repo;
    }
}
