package com.example.Jwt_AuthProject.service;
import java.util.Optional;

import com.example.Jwt_AuthProject.exception.CustomerException;
import com.example.Jwt_AuthProject.model.Customer;
import com.example.Jwt_AuthProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) throws CustomerException
    {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
      return  customerRepository.findByEmail(email);

    }


}
