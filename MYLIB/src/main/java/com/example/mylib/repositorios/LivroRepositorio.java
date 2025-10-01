package com.example.mylib.repositorios;

import com.example.mylib.modelos.Autor;
import com.example.mylib.modelos.Livro;
import com.example.mylib.modelos.enums.CategoriaLivro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {

    List<Livro> findByAutor(Autor autor);

    List<Livro> findByCategoria(CategoriaLivro categoria);

    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    List<Livro> findByDataLancamento(LocalDate dataLancamento);
}
