package com.example.mylib.dtos;

import java.time.LocalDate;

public class AutorRespostaDto {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String biografia;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void definirDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void definirBiografia(String biografia) {
        this.biografia = biografia;
    }
}
