package com.example.mylib.services;

import com.example.mylib.Categoria;
import com.example.mylib.models.Livro;
import com.example.mylib.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    public Livro postLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro getLivro(UUID id){
        return livroRepository.findLivroById(id);
    }

    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    public List<Livro> getLivros(String autor){
        return livroRepository.findAllByAutor(autor);
    }

    public Livro getLivroTitulo(String titulo){
        return livroRepository.findLivroByTitulo(titulo);
    }

    public List<Livro> getLivros(Categoria categoria){
        return livroRepository.findAllByCategoria(categoria);
    }

    public boolean deleteLivro(UUID id){
        return deleteLivro(id);
    }

}
