package com.example.mylib.repositories;

import com.example.mylib.models.Estante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstanteRepository extends JpaRepository<Estante, Long> {
}
