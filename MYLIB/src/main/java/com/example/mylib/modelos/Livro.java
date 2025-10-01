package com.example.mylib.modelos;

import com.example.mylib.modelos.enums.CategoriaLivro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livro_id")
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaLivro categoria;

    @FutureOrPresent
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @JsonIgnore
    @ManyToMany(mappedBy = "livros")
    private Set<Biblioteca> bibliotecas = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void definirId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void definirTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void definirDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaLivro getCategoria() {
        return categoria;
    }

    public void definirCategoria(CategoriaLivro categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void definirDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void definirAutor(Autor autor) {
        this.autor = autor;
    }

    public Set<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void definirBibliotecas(Set<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }
}
