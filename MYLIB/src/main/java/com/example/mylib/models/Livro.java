package com.example.mylib.models;

import com.example.mylib.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name = "livro_db")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(name = "titulo")
    private String titulo;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @NotBlank
    @Column(name = "categoria")
    private Categoria categoria;

    @Column(name = "lancamento")
    private LocalDateTime lancamento;

    @Column(name = "lido")
    private boolean Lido;


}
