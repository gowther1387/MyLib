package com.example.mylib.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
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


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return admin == user.admin && senha == user.senha && Objects.equals(id, user.id) && Objects.equals(nome, user.nome) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, admin, email, senha);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", admin=" + admin +
                ", email='" + email + '\'' +
                ", senha=" + senha +
                '}';
    }
}
