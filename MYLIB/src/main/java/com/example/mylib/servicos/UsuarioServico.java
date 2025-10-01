package com.example.mylib.servicos;

import com.example.mylib.dtos.UsuarioCadastroDto;
import com.example.mylib.dtos.UsuarioRespostaDto;
import com.example.mylib.excecoes.ErroNegocioException;
import com.example.mylib.excecoes.RecursoNaoEncontradoException;
import com.example.mylib.modelos.Biblioteca;
import com.example.mylib.modelos.Usuario;
import com.example.mylib.modelos.enums.PerfilUsuario;
import com.example.mylib.repositorios.BibliotecaRepositorio;
import com.example.mylib.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final BibliotecaRepositorio bibliotecaRepositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServico(UsuarioRepositorio usuarioRepositorio,
                          BibliotecaRepositorio bibliotecaRepositorio,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.bibliotecaRepositorio = bibliotecaRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioRespostaDto registrarUsuario(UsuarioCadastroDto dto) {
        if (usuarioRepositorio.existsByEmail(dto.getEmail())) {
            throw new ErroNegocioException("Já existe um usuário cadastrado com este e-mail");
        }

        Usuario usuario = new Usuario();
        usuario.definirNome(dto.getNome());
        usuario.definirEmail(dto.getEmail());
        usuario.definirSenha(passwordEncoder.encode(dto.getSenha()));
        if (dto.getPerfil() != null) {
            usuario.definirPerfil(converterPerfil(dto.getPerfil()));
        }
        if (dto.getBibliotecaId() != null) {
            Biblioteca biblioteca = bibliotecaRepositorio.findById(dto.getBibliotecaId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Biblioteca não encontrada"));
            usuario.definirBiblioteca(biblioteca);
            biblioteca.getUsuarios().add(usuario);
        }

        Usuario salvo = usuarioRepositorio.save(usuario);
        return converterParaResposta(salvo);
    }

    @Transactional(readOnly = true)
    public List<UsuarioRespostaDto> listarUsuarios() {
        return usuarioRepositorio.findAll().stream()
                .map(this::converterParaResposta)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioRespostaDto buscarUsuarioPorId(Long id) {
        Usuario usuario = obterUsuario(id);
        return converterParaResposta(usuario);
    }

    @Transactional
    public UsuarioRespostaDto atualizarUsuario(Long id, UsuarioCadastroDto dto) {
        Usuario usuario = obterUsuario(id);
        usuario.definirNome(dto.getNome());
        usuario.definirEmail(dto.getEmail());
        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
            usuario.definirSenha(passwordEncoder.encode(dto.getSenha()));
        }
        if (dto.getPerfil() != null) {
            usuario.definirPerfil(converterPerfil(dto.getPerfil()));
        }
        if (dto.getBibliotecaId() != null) {
            Biblioteca biblioteca = bibliotecaRepositorio.findById(dto.getBibliotecaId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Biblioteca não encontrada"));
            usuario.definirBiblioteca(biblioteca);
        } else {
            usuario.definirBiblioteca(null);
        }
        Usuario atualizado = usuarioRepositorio.save(usuario);
        return converterParaResposta(atualizado);
    }

    @Transactional
    public void removerUsuario(Long id) {
        Usuario usuario = obterUsuario(id);
        usuarioRepositorio.delete(usuario);
    }

    private Usuario obterUsuario(Long id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
    }

    private PerfilUsuario converterPerfil(String perfil) {
        try {
            return PerfilUsuario.valueOf(perfil.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new ErroNegocioException("Perfil informado é inválido");
        }
    }

    private UsuarioRespostaDto converterParaResposta(Usuario usuario) {
        UsuarioRespostaDto resposta = new UsuarioRespostaDto();
        resposta.definirId(usuario.getId());
        resposta.definirNome(usuario.getNome());
        resposta.definirEmail(usuario.getEmail());
        resposta.definirPerfil(usuario.getPerfil().name());
        if (usuario.getBiblioteca() != null) {
            resposta.definirBibliotecaId(usuario.getBiblioteca().getId());
            resposta.definirNomeBiblioteca(usuario.getBiblioteca().getNome());
        }
        return resposta;
    }
}
