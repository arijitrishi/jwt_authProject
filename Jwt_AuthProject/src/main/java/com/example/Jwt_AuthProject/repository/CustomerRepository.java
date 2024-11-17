package com.example.Jwt_AuthProject.repository;
import java.util.Optional;

import com.example.Jwt_AuthProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

    public Optional<Customer> findByEmail(String email);
}
