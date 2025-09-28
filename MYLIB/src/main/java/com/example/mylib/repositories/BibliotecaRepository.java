package com.example.mylib.repositories;

import com.example.mylib.models.Autor;
import com.example.mylib.models.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
