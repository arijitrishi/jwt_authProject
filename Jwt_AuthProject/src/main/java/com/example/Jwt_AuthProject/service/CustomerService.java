package com.example.Jwt_AuthProject.service;
import com.example.Jwt_AuthProject.model.Customer;

import java.util.Optional;


public interface CustomerService
{

    public Customer registerCustomer(Customer customer);

public Optional<Customer> findByEmail(String email);

}
