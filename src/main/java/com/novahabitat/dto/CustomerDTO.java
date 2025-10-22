package com.novahabitat.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private int idCustomer;

    @NotNull
    //@NotEmpty
    //@NotBlank
    @Size(min = 3, max = 70)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 70)
    private String lastName;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String phone;

    @Email
    private String email;

    @NotNull
    private String dni;
    private String address;
}