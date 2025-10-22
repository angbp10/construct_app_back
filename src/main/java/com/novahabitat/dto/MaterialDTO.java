package com.novahabitat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {
    private Integer idMaterial;
    private String name;
    private String measurementUnit; // unidad de medida
    private Double unitPrice;
    private Integer actualStock;
    private SupplierDTO supplier;
}