package com.novahabitat.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {
    @NotNull
    private Integer idMaterial;
    @NotNull
    private String name;
    @NotNull
    private String measurementUnit; // unidad de medida
    @NotNull
    private Double unitPrice;
    @NotNull
    private Integer actualStock;

    private SupplierDTO supplier;
}