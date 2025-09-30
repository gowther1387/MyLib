package com.example.mylib.controllers;

import com.example.mylib.models.Biblioteca;
import com.example.mylib.services.BibliotecaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @PostMapping
    public void postBiblioteca(@RequestBody Biblioteca biblioteca) {
        bibliotecaService.postBiblioteca(biblioteca);
    }

    @PostMapping("/{bibliotecaId}/usuarios/{userId}")
    public Biblioteca addUsuario(@PathVariable Long bibliotecaId, @PathVariable Long userId) {
        return bibliotecaService.addUsuario(bibliotecaId, userId);
    }

    @PatchMapping("/{bibliotecaId}/livros")
    public Biblioteca patchLivros(@PathVariable Long bibliotecaId) {
        return bibliotecaService.pathLivro(bibliotecaId);
    }

    @DeleteMapping("/{bibliotecaId}/livros/{livroId}")
    public Biblioteca removerLivro(@PathVariable Long bibliotecaId, @PathVariable Long livroId) {
        return bibliotecaService.removerLivro(bibliotecaId, livroId);
    }

    @DeleteMapping("/{bibliotecaId}")
    public void deleteBiblioteca(@PathVariable Long bibliotecaId) {
        bibliotecaService.deleteBiblioteca(bibliotecaId);
    }
}