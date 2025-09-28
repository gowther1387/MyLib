package com.example.mylib.services;


import com.example.mylib.models.Autor;
import com.example.mylib.models.Biblioteca;
import com.example.mylib.repositories.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }


    public void postBiblioteca(Biblioteca biblioteca) {
        bibliotecaRepository.save(biblioteca);
    }

    public Biblioteca pathLivro(long id) {
        Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);
        if (bibliotecaOptional.isPresent()) {
            Biblioteca biblioteca = bibliotecaOptional.get();
            biblioteca.setLivros(biblioteca.getLivros());
            return bibliotecaRepository.save(biblioteca);
        }
        return null;
    }

    public Biblioteca pathUser(long id) {
        Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);
        if (bibliotecaOptional.isPresent()) {
            Biblioteca biblioteca = bibliotecaOptional.get();
            biblioteca.getUsuario(biblioteca.getUsuario());
            return bibliotecaRepository.save(biblioteca);
        }
        return null;
    }


}
