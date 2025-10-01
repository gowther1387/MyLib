package com.example.mylib.dtos;

import jakarta.validation.constraints.NotBlank;

public class BibliotecaCadastroDto {

    @NotBlank
    private String nome;

    private String descricao;

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
}
