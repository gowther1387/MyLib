package com.example.mylib.servicos;

import com.example.mylib.dtos.LivroCadastroDto;
import com.example.mylib.dtos.LivroRespostaDto;
import com.example.mylib.excecoes.ErroNegocioException;
import com.example.mylib.excecoes.RecursoNaoEncontradoException;
import com.example.mylib.modelos.Autor;
import com.example.mylib.modelos.Livro;
import com.example.mylib.modelos.enums.CategoriaLivro;
import com.example.mylib.repositorios.AutorRepositorio;
import com.example.mylib.repositorios.LivroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class LivroServico {

    private final LivroRepositorio livroRepositorio;
    private final AutorRepositorio autorRepositorio;

    public LivroServico(LivroRepositorio livroRepositorio, AutorRepositorio autorRepositorio) {
        this.livroRepositorio = livroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    @Transactional
    public LivroRespostaDto criarLivro(LivroCadastroDto dto) {
        Autor autor = obterAutor(dto.getAutorId());
        CategoriaLivro categoria = converterCategoria(dto.getCategoria());

        Livro livro = new Livro();
        livro.definirTitulo(dto.getTitulo());
        livro.definirDescricao(dto.getDescricao());
        livro.definirCategoria(categoria);
        livro.definirDataLancamento(dto.getDataLancamento());
        livro.definirAutor(autor);
        Livro salvo = livroRepositorio.save(livro);
        return converterParaResposta(salvo);
    }

    @Transactional(readOnly = true)
    public List<LivroRespostaDto> listarLivros(String titulo, Long autorId, String categoria, LocalDate dataLancamento) {
        if (autorId != null) {
            Autor autor = obterAutor(autorId);
            return livroRepositorio.findByAutor(autor).stream().map(this::converterParaResposta).collect(Collectors.toList());
        }

        if (categoria != null) {
            CategoriaLivro categoriaLivro = converterCategoria(categoria);
            return livroRepositorio.findByCategoria(categoriaLivro).stream().map(this::converterParaResposta).collect(Collectors.toList());
        }

        if (titulo != null) {
            return livroRepositorio.findByTituloContainingIgnoreCase(titulo).stream()
                    .map(this::converterParaResposta)
                    .collect(Collectors.toList());
        }

        if (dataLancamento != null) {
            return livroRepositorio.findByDataLancamento(dataLancamento).stream()
                    .map(this::converterParaResposta)
                    .collect(Collectors.toList());
        }

        return livroRepositorio.findAll().stream()
                .sorted(Comparator.comparing(Livro::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .map(this::converterParaResposta)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LivroRespostaDto buscarLivroPorId(Long id) {
        Livro livro = livroRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado"));
        return converterParaResposta(livro);
    }

    @Transactional
    public LivroRespostaDto atualizarLivro(Long id, LivroCadastroDto dto) {
        Livro livro = livroRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado"));
        Autor autor = obterAutor(dto.getAutorId());
        CategoriaLivro categoria = converterCategoria(dto.getCategoria());

        livro.definirTitulo(dto.getTitulo());
        livro.definirDescricao(dto.getDescricao());
        livro.definirCategoria(categoria);
        livro.definirDataLancamento(dto.getDataLancamento());
        livro.definirAutor(autor);

        return converterParaResposta(livroRepositorio.save(livro));
    }

    @Transactional
    public void removerLivro(Long id) {
        Livro livro = livroRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado"));
        livroRepositorio.delete(livro);
    }

    private CategoriaLivro converterCategoria(String categoria) {
        try {
            return CategoriaLivro.valueOf(categoria.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new ErroNegocioException("Categoria informada é inválida");
        }
    }

    private Autor obterAutor(Long autorId) {
        return autorRepositorio.findById(autorId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Autor não encontrado"));
    }

    private LivroRespostaDto converterParaResposta(Livro livro) {
        LivroRespostaDto resposta = new LivroRespostaDto();
        resposta.definirId(livro.getId());
        resposta.definirTitulo(livro.getTitulo());
        resposta.definirDescricao(livro.getDescricao());
        resposta.definirCategoria(livro.getCategoria().name());
        resposta.definirDataLancamento(livro.getDataLancamento());
        if (livro.getAutor() != null) {
            resposta.definirAutorId(livro.getAutor().getId());
            resposta.definirNomeAutor(livro.getAutor().getNome());
        }
        return resposta;
    }
}
