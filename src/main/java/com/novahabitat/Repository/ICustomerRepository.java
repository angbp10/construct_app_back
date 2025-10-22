package com.novahabitat.Repository;

import com.novahabitat.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends IGenericRepository<Customer,Integer> {
    //Customer save(Customer customer);
}