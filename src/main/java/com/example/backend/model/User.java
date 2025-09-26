package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Se autogenera al insertar

    private String picture_large;
    private String city;
    private String email;
    private String first_name;
    private String gender;
    private String last_name;
    private String name_title;
    private String phone;
    private Integer postcode;
    private String state;
}

