package com.example.mylib.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bibliotecas")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "biblioteca_id")
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "biblioteca_livros",
            joinColumns = @JoinColumn(name = "biblioteca_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private Set<Livro> livros = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Usuario> usuarios = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void definirId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void definirDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void definirLivros(Set<Livro> livros) {
        this.livros = livros;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void definirUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
