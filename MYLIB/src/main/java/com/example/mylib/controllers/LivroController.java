package com.example.mylib.controllers;

import com.example.mylib.models.Livro;
import com.example.mylib.repositories.LivroRepository;
import com.example.mylib.services.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    private LivroService livroService;
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro postLivro(@RequestBody Livro livro) {
        return livroService.postLivro(livro);
    }

    @GetMapping("/buscar/{id}")
    public Livro getLivroById(UUID id){
        return livroService.getLivro(id);
    }
    @GetMapping
    public Livro getLivro(String titulo){
        return livroService.getLivroTitulo(titulo);
    }

    @GetMapping
    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    @GetMapping
    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    @GetMapping
    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }


    @DeleteMapping
    public void deleteLivro(@RequestBody UUID id){
        livroRepository.deleteById(id);
    }
}
