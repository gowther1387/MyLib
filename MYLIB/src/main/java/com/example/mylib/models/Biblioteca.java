package com.example.mylib.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bibliotecatb")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "biblioteca_id")
    private long bibliotecaId;

    @Column
    private String nome;

    @OneToMany(mappedBy = "user")
    private List<User> usuario;

    @ManyToMany
    @JoinTable(
            name = "biblioteca_livro", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "biblioteca_id"), // Chave estrangeira para Biblioteca
            inverseJoinColumns = @JoinColumn(name = "livro_id") // Chave estrangeira para Livro
    )
    private List<Livro> livros;
    

    public long getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(long bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<User> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<User> usuario) {
        this.usuario = usuario;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
