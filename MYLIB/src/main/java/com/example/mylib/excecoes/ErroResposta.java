package com.example.mylib.excecoes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ErroResposta {

    private final Instant momento = Instant.now();
    private final int status;
    private final String mensagem;
    private final String caminho;
    private final List<String> detalhes = new ArrayList<>();

    public ErroResposta(int status, String mensagem, String caminho) {
        this.status = status;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }

    public Instant getMomento() {
        return momento;
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public List<String> getDetalhes() {
        return detalhes;
    }

    public void adicionarDetalhe(String detalhe) {
        this.detalhes.add(detalhe);
    }
}
