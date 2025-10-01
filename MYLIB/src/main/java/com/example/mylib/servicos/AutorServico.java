package com.example.mylib.servicos;

import com.example.mylib.dtos.AutorCadastroDto;
import com.example.mylib.dtos.AutorRespostaDto;
import com.example.mylib.excecoes.RecursoNaoEncontradoException;
import com.example.mylib.modelos.Autor;
import com.example.mylib.repositorios.AutorRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorServico {

    private final AutorRepositorio autorRepositorio;

    public AutorServico(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    @Transactional
    public AutorRespostaDto criarAutor(AutorCadastroDto dto) {
        Autor autor = new Autor();
        autor.definirNome(dto.getNome());
        autor.definirDataNascimento(dto.getDataNascimento());
        autor.definirBiografia(dto.getBiografia());
        Autor salvo = autorRepositorio.save(autor);
        return converterParaResposta(salvo);
    }

    @Transactional(readOnly = true)
    public List<AutorRespostaDto> listarAutores() {
        return autorRepositorio.findAll()
                .stream()
                .map(this::converterParaResposta)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AutorRespostaDto buscarAutorPorId(Long id) {
        Autor autor = autorRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Autor não encontrado"));
        return converterParaResposta(autor);
    }

    @Transactional
    public AutorRespostaDto atualizarAutor(Long id, AutorCadastroDto dto) {
        Autor autor = autorRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Autor não encontrado"));
        autor.definirNome(dto.getNome());
        autor.definirDataNascimento(dto.getDataNascimento());
        autor.definirBiografia(dto.getBiografia());
        return converterParaResposta(autorRepositorio.save(autor));
    }

    @Transactional
    public void removerAutor(Long id) {
        Autor autor = autorRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Autor não encontrado"));
        autorRepositorio.delete(autor);
    }

    private AutorRespostaDto converterParaResposta(Autor autor) {
        AutorRespostaDto resposta = new AutorRespostaDto();
        resposta.definirId(autor.getId());
        resposta.definirNome(autor.getNome());
        resposta.definirDataNascimento(autor.getDataNascimento());
        resposta.definirBiografia(autor.getBiografia());
        return resposta;
    }
}
