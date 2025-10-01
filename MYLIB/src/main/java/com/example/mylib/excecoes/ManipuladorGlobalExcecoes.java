package com.example.mylib.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ManipuladorGlobalExcecoes {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResposta> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex, WebRequest request) {
        ErroResposta resposta = new ErroResposta(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }

    @ExceptionHandler(ErroNegocioException.class)
    public ResponseEntity<ErroResposta> tratarErroNegocio(ErroNegocioException ex, WebRequest request) {
        ErroResposta resposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarValidacao(MethodArgumentNotValidException ex, WebRequest request) {
        ErroResposta resposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), "Campos inválidos", request.getDescription(false));
        for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
            resposta.adicionarDetalhe(erro.getField() + ": " + erro.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> tratarExcecaoGenerica(Exception ex, WebRequest request) {
        ErroResposta resposta = new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocorreu um erro inesperado", request.getDescription(false));
        resposta.adicionarDetalhe(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposta);
    }
}
