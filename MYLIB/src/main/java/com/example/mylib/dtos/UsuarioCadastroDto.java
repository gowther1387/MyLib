package com.example.mylib.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioCadastroDto {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    private String senha;

    private String perfil;

    private Long bibliotecaId;

    public String getNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void definirEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void definirSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void definirPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Long getBibliotecaId() {
        return bibliotecaId;
    }

    public void definirBibliotecaId(Long bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }
}
