package com.example.mylib.controllers;

import com.example.mylib.dtos.LivroDTO;
import com.example.mylib.models.Livro;
import com.example.mylib.repositories.LivroRepository;
import com.example.mylib.services.LivroService;
import org.hibernate.sql.model.ModelMutationLogging;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    private ModelMapper modelMapper ;
    private LivroService livroService;

    public LivroController(LivroService livroService, ModelMapper modelMapper) {
        this.livroService = livroService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public Livro postLivro(@RequestBody Livro livro) {
        return livroService.postLivro(livro);
    }

    @GetMapping("/buscar/{id}")
    public LivroDTO getLivroById(@PathVariable Long id){
        Livro livro = livroService.getLivro(id);
        return modelMapper.map(livro, LivroDTO.class);
    }
    @GetMapping("/livro/{titulo}")
    public LivroDTO getLivro(@PathVariable String titulo){
        Livro livro = livroService.getLivroTitulo(titulo);
        return modelMapper.map(livro, LivroDTO.class);
    }

    @DeleteMapping("/livro/{id}")
    public void deleteLivro(@PathVariable Long id){
        livroService.deleteLivro(id);

    }
}
