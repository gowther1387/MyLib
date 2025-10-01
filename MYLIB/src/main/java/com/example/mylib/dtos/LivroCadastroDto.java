package com.example.mylib.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LivroCadastroDto {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String categoria;

    @FutureOrPresent
    private LocalDate dataLancamento;

    @NotNull
    private Long autorId;

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
}
