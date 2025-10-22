package com.novahabitat.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Material {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaterial;

    private String name;
    private String measurementUnit; // unidad de medida
    private Double unitPrice;
    private Integer actualStock;

    @ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_supplier", nullable = false)
    @JsonBackReference
    private Supplier supplier;
}

