package com.novahabitat.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor con todos los atributos
@Data //Genera getters y setters
@Entity
@Table(name = "customer")//, schema = "ventas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    @Column(nullable = false, length = 70)//, name = "nombres")
    private String firstName;

    @Column(nullable = false, length = 70)
    private String lastName;

    @Column( length = 70)
    private String email;

    @Column(length = 30)
    private String phone;

    @Column(nullable = false, length = 20)
    private String dni; // DNI, pasaporte, etc.

    @Column(length = 150)
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Project> projects;

    /*
    public Customer() {
    }

    public Customer(int idCustomer, String name) {
        this.idCustomer = idCustomer;
        this.name = name;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    */
}