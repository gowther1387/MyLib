package com.example.mylib.repositorios;

import com.example.mylib.modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}
