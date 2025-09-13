package com.example.mylib.repositories;

import com.example.mylib.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor,UUID> {
    Autor getAutorById(UUID id);
}
