package com.novahabitat.controller;

import com.novahabitat.dto.SupplierDTO;
import com.novahabitat.Model.Supplier;
import com.novahabitat.service.ISupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
//@CrossOrigin(origins = "*")
//@AllArgsConstructor
@RequiredArgsConstructor
public class SupplierController {
    private final ISupplierService service;
    private final ModelMapper modelMapper;

    // http://localhost:9090/customers
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> findAll() throws Exception{
        List<SupplierDTO> list = service.findAll().stream().map(this::convertToDto).toList();;
        return ResponseEntity.ok(list);
    }
    // http://localhost:9090/customers/5
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> findById(@PathVariable("id") Integer id) throws Exception{
        SupplierDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }
    // http://localhost:9090/customers
    @PostMapping
    public ResponseEntity<SupplierDTO> save(@RequestBody SupplierDTO dto) throws Exception{
        Supplier obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSupplier()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(@RequestBody SupplierDTO dto, @PathVariable("id") Integer id) throws Exception{
        Supplier obj = service.update(convertToEntity(dto), id);
        SupplierDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private SupplierDTO convertToDto(Supplier obj){
        return modelMapper.map(obj, SupplierDTO.class);
    }

    private Supplier convertToEntity(SupplierDTO dto){
        return modelMapper.map(dto, Supplier.class);
    }
}

