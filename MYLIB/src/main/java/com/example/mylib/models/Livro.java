package com.example.mylib.models;

import com.example.mylib.Categoria;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "livro_db")
public class Livro {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "livro_id")
    private long id;


    @Column(name = "titulo")
    private String titulo;


    @Column(name = "descricao")
    private String descricao;


    @Column(name = "categoria")
    private Categoria categoria;

    @Column(name = "lancamento")
    private LocalDateTime lancamento;

    @ManyToOne()
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToMany(mappedBy = "livros")
    private List<Biblioteca> bibliotecas;


    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDateTime lancamento) {
        this.lancamento = lancamento;
    }



}
