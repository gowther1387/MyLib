package com.example.mylib.excecoes;

public class ErroNegocioException extends RuntimeException {

    public ErroNegocioException(String mensagem) {
        super(mensagem);
    }
}
