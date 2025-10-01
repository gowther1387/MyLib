package com.example.mylib.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

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
}
