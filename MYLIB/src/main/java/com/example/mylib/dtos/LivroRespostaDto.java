package com.example.mylib.dtos;

import java.time.LocalDate;

public class LivroRespostaDto {

    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private LocalDate dataLancamento;
    private Long autorId;
    private String nomeAutor;

    public Long getId() {
        return id;
    }

    public void definirId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void definirTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void definirDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void definirCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void definirDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void definirAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void definirNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}
