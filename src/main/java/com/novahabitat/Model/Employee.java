package com.novahabitat.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEmployee;
    private String name;
    private String position; // Cargo
    private String specialty; // Especialidad
    private LocalDate hireDate; // Fecha de ingreso
    private Double salary;

    /*@ManyToOne // FK (Foreign Key)
    @JoinColumn(name="id_project", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYEE_PROJECT") )
    private Project project;
     */
}