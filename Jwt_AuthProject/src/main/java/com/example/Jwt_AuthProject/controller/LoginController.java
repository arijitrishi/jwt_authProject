package com.example.Jwt_AuthProject.controller;

import com.example.Jwt_AuthProject.model.Customer;
import com.example.Jwt_AuthProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController
{

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/signIn")
    public ResponseEntity<Customer> CustomerLoginDetailsHandler(Authentication auth)
    {

        Customer customer = customerRepository.findByEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Invalid Username password"));

        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

}
