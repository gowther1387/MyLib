package com.example.mylib.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class AutorCadastroDto {

    @NotBlank
    private String nome;

    @Past
    private LocalDate dataNascimento;

    private String biografia;

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
