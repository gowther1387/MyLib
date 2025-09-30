package com.example.mylib.repositories;

import com.example.mylib.Categoria;
import com.example.mylib.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findLivroById(Long id);
    Livro findLivroByTitulo(String titulo);
    List<Livro> findAllByCategoria(Categoria categoria);
    List<Livro> findAllByAutor(String autor);
    List<Livro> findAllByLancamento(String titulo);
}
