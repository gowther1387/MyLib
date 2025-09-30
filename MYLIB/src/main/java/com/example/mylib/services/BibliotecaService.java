package com.example.mylib.services;


import com.example.mylib.models.Autor;
import com.example.mylib.models.Biblioteca;
import com.example.mylib.models.Livro;
import com.example.mylib.models.User;
import com.example.mylib.repositories.AutorRepository;
import com.example.mylib.repositories.BibliotecaRepository;
import com.example.mylib.repositories.LivroRepository;
import com.example.mylib.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;
    private final UserRepository userRepository;
    private final LivroRepository livroRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository,  UserRepository userRepository, LivroRepository livroRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.userRepository = userRepository;
        this.livroRepository = livroRepository;

    }


    public void postBiblioteca(Biblioteca biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca addUsuario(Long id, Long userId) {
        Biblioteca biblioteca = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Biblioteca não encontrada"));

        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        biblioteca.getUsuario().add(usuario);
        return bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca pathLivro(Long id) {
        Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);
        if (bibliotecaOptional.isPresent()) {
            Biblioteca biblioteca = bibliotecaOptional.get();
            biblioteca.setLivros(biblioteca.getLivros());
            return bibliotecaRepository.save(biblioteca);
        }
        return null;
    }

    public Biblioteca removerLivro(Long bibliotecaId, Long id) {
        Biblioteca biblioteca = bibliotecaRepository.findById(bibliotecaId)
                .orElseThrow(() -> new RuntimeException("Biblioteca não encontrada"));

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        biblioteca.getLivros().remove(livro);

        return bibliotecaRepository.save(biblioteca);
    }

    public void deleteBiblioteca(Long id) {
        bibliotecaRepository.deleteById(id);
    }
}
