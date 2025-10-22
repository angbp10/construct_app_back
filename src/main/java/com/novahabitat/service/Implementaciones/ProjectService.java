package com.novahabitat.service.Implementaciones;

import com.novahabitat.Model.Project;
import com.novahabitat.Repository.IGenericRepository;
import com.novahabitat.Repository.IProjectRepository;
import com.novahabitat.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService extends GenericService<Project, Integer> implements IProjectService {

    private final IProjectRepository repo;
    @Override
    protected IGenericRepository<Project, Integer> getRepo() {
        return repo;
    }
}
