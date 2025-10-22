package com.novahabitat.controller;


import com.novahabitat.dto.ProjectDTO;
import com.novahabitat.Model.Project;
import com.novahabitat.service.IProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*")
//@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectService service;
    private final ModelMapper modelMapper;
    // http://localhost:9090/customers
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() throws Exception{
        List<ProjectDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }
    // http://localhost:9090/customers/5
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable("id") Integer id) throws Exception{
        ProjectDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }
    // http://localhost:9090/customers
    @PostMapping
    public ResponseEntity<Project> save(@RequestBody ProjectDTO dto) throws Exception{
        Project obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProject()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@Valid @PathVariable("id")  Integer id,@RequestBody ProjectDTO dto ) throws Exception{
        Project obj = service.update(convertToEntity(dto),id);
        ProjectDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
    private ProjectDTO convertToDto(Project obj){
        return modelMapper.map(obj, ProjectDTO.class);
    }

    private Project convertToEntity(ProjectDTO dto){
        return modelMapper.map(dto, Project.class);
    }
}
