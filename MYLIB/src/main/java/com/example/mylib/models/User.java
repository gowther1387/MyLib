package com.example.mylib.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "Usertb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    @NotBlank
    private String nome;

    @Column(name = "admin")
    private boolean admin;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "senha")
    private long senha;

}
