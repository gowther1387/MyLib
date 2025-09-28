package com.example.mylib.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "autor_id")
    private UUID autorId;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade")
    private LocalDate idade;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    public UUID getAutorId() {
        return autorId;
    }

    public void setAutorId(UUID autorId) {
        this.autorId = autorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
