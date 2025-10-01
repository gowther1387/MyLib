package com.example.mylib.dtos;

public class UsuarioRespostaDto {

    private Long id;
    private String nome;
    private String email;
    private String perfil;
    private Long bibliotecaId;
    private String nomeBiblioteca;

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

    public String getEmail() {
        return email;
    }

    public void definirEmail(String email) {
        this.email = email;
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

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void definirNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }
}
