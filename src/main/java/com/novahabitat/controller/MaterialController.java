package com.novahabitat.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.novahabitat.service.IMaterialService;
import com.novahabitat.dto.MaterialDTO;
import com.novahabitat.Model.Material;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/materials")
//@AllArgsConstructor
@RequiredArgsConstructor
public class MaterialController {
    private final IMaterialService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> findAll() throws Exception{
        List<MaterialDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> findById(@PathVariable("id") Integer id) throws Exception{
        MaterialDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Material>  save(@Valid @RequestBody MaterialDTO dto) throws Exception{
        Material obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdMaterial()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<MaterialDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MaterialDTO dto) throws Exception{
        Material obj = service.update(convertToEntity(dto), id);
        MaterialDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private MaterialDTO convertToDto(Material entity){
        return modelMapper.map(entity, MaterialDTO.class);
    }

    private Material convertToEntity(MaterialDTO dto){
        return modelMapper.map(dto, Material.class);
    }

}
