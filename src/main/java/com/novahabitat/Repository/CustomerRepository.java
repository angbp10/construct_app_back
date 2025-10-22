package com.novahabitat.Repository;

import com.novahabitat.Model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository  {
    //@Override
    public Customer save(Customer customer){
        System.out.println("Customer save to customer");
        return customer;
    }
}