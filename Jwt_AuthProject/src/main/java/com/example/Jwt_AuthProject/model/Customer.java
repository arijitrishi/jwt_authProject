package com.example.Jwt_AuthProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;
    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String address;

}
