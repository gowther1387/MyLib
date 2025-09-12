package com.example.mylib.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "estante_db")
public class Estante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long estanteId;

    @OneToMany(fetch = FetchType.LAZY)
    @Column
    private List<Livro> livro;
}
