package com.example.Jwt_AuthProject.controller;

import com.example.Jwt_AuthProject.model.Customer;
import com.example.Jwt_AuthProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SignupController
{

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/customers")
    public ResponseEntity<String> saveCustomerHandler(@RequestBody Customer customer)
    {
if (customerService.findByEmail(customer.getEmail()).isPresent()){
    return ResponseEntity.badRequest().body("Email is already in use!");
    }
        if (!isValidPassword(customer.getPassword())) {
            return ResponseEntity.badRequest().body("Password must have at least one uppercase letter, one number, and one special character");
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        Customer registeredCustomer = customerService.registerCustomer(customer);

        customerService.registerCustomer(customer);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/hello")
    public String testHandler()
    {
        return "Welcome Arijit";
    }


    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
}
