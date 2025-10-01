package com.example.mylib.servicos;

import com.example.mylib.dtos.BibliotecaCadastroDto;
import com.example.mylib.dtos.BibliotecaRespostaDto;
import com.example.mylib.excecoes.ErroNegocioException;
import com.example.mylib.excecoes.RecursoNaoEncontradoException;
import com.example.mylib.modelos.Biblioteca;
import com.example.mylib.modelos.Livro;
import com.example.mylib.modelos.Usuario;
import com.example.mylib.repositorios.BibliotecaRepositorio;
import com.example.mylib.repositorios.LivroRepositorio;
import com.example.mylib.repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaServico {

    private final BibliotecaRepositorio bibliotecaRepositorio;
    private final LivroRepositorio livroRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public BibliotecaServico(BibliotecaRepositorio bibliotecaRepositorio,
                             LivroRepositorio livroRepositorio,
                             UsuarioRepositorio usuarioRepositorio) {
        this.bibliotecaRepositorio = bibliotecaRepositorio;
        this.livroRepositorio = livroRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Transactional
    public BibliotecaRespostaDto criarBiblioteca(BibliotecaCadastroDto dto) {
        bibliotecaRepositorio.findByNomeIgnoreCase(dto.getNome()).ifPresent(biblioteca -> {
            throw new ErroNegocioException("Já existe uma biblioteca com este nome");
        });

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.definirNome(dto.getNome());
        biblioteca.definirDescricao(dto.getDescricao());
        Biblioteca salva = bibliotecaRepositorio.save(biblioteca);
        return converterParaResposta(salva);
    }

    @Transactional(readOnly = true)
    public List<BibliotecaRespostaDto> listarBibliotecas() {
        return bibliotecaRepositorio.findAll().stream()
                .map(this::converterParaResposta)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BibliotecaRespostaDto buscarBibliotecaPorId(Long id) {
        Biblioteca biblioteca = obterBiblioteca(id);
        return converterParaResposta(biblioteca);
    }

    @Transactional
    public BibliotecaRespostaDto atualizarBiblioteca(Long id, BibliotecaCadastroDto dto) {
        Biblioteca biblioteca = obterBiblioteca(id);
        biblioteca.definirNome(dto.getNome());
        biblioteca.definirDescricao(dto.getDescricao());
        return converterParaResposta(bibliotecaRepositorio.save(biblioteca));
    }

    @Transactional
    public void removerBiblioteca(Long id) {
        Biblioteca biblioteca = obterBiblioteca(id);
        bibliotecaRepositorio.delete(biblioteca);
    }

    @Transactional
    public BibliotecaRespostaDto adicionarLivro(Long bibliotecaId, Long livroId) {
        Biblioteca biblioteca = obterBiblioteca(bibliotecaId);
        Livro livro = livroRepositorio.findById(livroId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Livro não encontrado"));
        biblioteca.getLivros().add(livro);
        livro.getBibliotecas().add(biblioteca);
        return converterParaResposta(biblioteca);
    }

    @Transactional
    public BibliotecaRespostaDto associarUsuario(Long bibliotecaId, Long usuarioId) {
        Biblioteca biblioteca = obterBiblioteca(bibliotecaId);
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
        usuario.definirBiblioteca(biblioteca);
        biblioteca.getUsuarios().add(usuario);
        return converterParaResposta(biblioteca);
    }

    private Biblioteca obterBiblioteca(Long id) {
        return bibliotecaRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Biblioteca não encontrada"));
    }

    private BibliotecaRespostaDto converterParaResposta(Biblioteca biblioteca) {
        BibliotecaRespostaDto resposta = new BibliotecaRespostaDto();
        resposta.definirId(biblioteca.getId());
        resposta.definirNome(biblioteca.getNome());
        resposta.definirDescricao(biblioteca.getDescricao());
        resposta.definirQuantidadeLivros(biblioteca.getLivros().size());
        resposta.definirQuantidadeUsuarios(biblioteca.getUsuarios().size());
        return resposta;
    }
}
