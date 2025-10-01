package com.example.mylib.repositorios;

import com.example.mylib.modelos.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BibliotecaRepositorio extends JpaRepository<Biblioteca, Long> {

    Optional<Biblioteca> findByNomeIgnoreCase(String nome);
}
