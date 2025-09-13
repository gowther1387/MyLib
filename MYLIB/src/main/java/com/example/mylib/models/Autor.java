package com.example.mylib.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID autorId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numlivros")
private double numLivros;

    @Column(name = "idade")
    private LocalDate idade;
}
