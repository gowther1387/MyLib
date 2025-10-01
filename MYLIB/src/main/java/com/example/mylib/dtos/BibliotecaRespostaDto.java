package com.example.mylib.dtos;

public class BibliotecaRespostaDto {

    private Long id;
    private String nome;
    private String descricao;
    private int quantidadeLivros;
    private int quantidadeUsuarios;

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

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }

    public void definirQuantidadeLivros(int quantidadeLivros) {
        this.quantidadeLivros = quantidadeLivros;
    }

    public int getQuantidadeUsuarios() {
        return quantidadeUsuarios;
    }

    public void definirQuantidadeUsuarios(int quantidadeUsuarios) {
        this.quantidadeUsuarios = quantidadeUsuarios;
    }
}
