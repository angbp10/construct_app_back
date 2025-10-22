package com.novahabitat.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private int idProject;
    private String name;
    private String location;
    private Date startDate;
    @NotNull(message = "La fecha estimada de fin es obligatoria.")
    private Date estimatedEndDate;
    private String status;
    private CustomerDTO customer;
}