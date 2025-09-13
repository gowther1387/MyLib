package com.example.mylib.services;

import com.example.mylib.models.Autor;
import com.example.mylib.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor postAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor getAutor(UUID id) {
        return autorRepository.getAutorById(id);
    }

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public void deleteAutor(UUID id) {
        autorRepository.deleteById(id);
    }
}
