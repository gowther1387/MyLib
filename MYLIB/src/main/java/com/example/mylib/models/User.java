package com.example.mylib.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Usertb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private long userId;

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

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Biblioteca biblioteca;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return admin == user.admin && senha == user.senha && Objects.equals(userId, user.userId) && Objects.equals(nome, user.nome) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nome, admin, email, senha);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", nome='" + nome + '\'' +
                ", admin=" + admin +
                ", email='" + email + '\'' +
                ", senha=" + senha +
                '}';
    }
}
