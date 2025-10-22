package com.novahabitat.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaterial;
    @NotNull(message = "El nombre del material es obligatorio")
    @Size(min = 3, max = 100)
    private String name;
    @Column(nullable = false, length = 20)
    @NotNull(message = "La unidad de medida es obligatoria")
    @Size(min = 1, max = 20)
    private String measurementUnit; // unidad de medida
    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "El precio unitario es obligatorio")
    @Positive(message = "El precio debe ser positivo")
    private Double unitPrice;
    @Column(nullable = false)
    @NotNull(message = "El stock actual es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer actualStock;
    @NotNull(message = "El proveedor es obligatorio")
    private SupplierDTO supplier;
}