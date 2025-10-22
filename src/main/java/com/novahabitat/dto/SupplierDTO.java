package com.novahabitat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
    private int idSupplier;
    private String name;
    private String ruc;
    private String phone;
    private String email;
    private String address;

}
