package com.example.mylib.controllers;

import com.example.mylib.models.Autor;
import com.example.mylib.services.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private final AutorService autorService;
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public Autor postAutor(@RequestBody Autor autor) {
        return autorService.postAutor(autor);
    }

    @GetMapping("/{id}")
    public Autor getAutor(@PathVariable UUID id) {
        return autorService.getAutor(id);
    }

    @GetMapping("/autores")
    public List<Autor> getAutores() {
        return autorService.getAllAutores();
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable UUID id) {
        autorService.deleteAutor(id);
    }



}
