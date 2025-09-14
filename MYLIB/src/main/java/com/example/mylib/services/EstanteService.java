package com.example.mylib.services;

import com.example.mylib.models.Estante;
import com.example.mylib.repositories.EstanteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstanteService {

    private final EstanteRepository estanteRepository;

    public EstanteService(EstanteRepository estanteRepository) {
        this.estanteRepository = estanteRepository;
    }

    public Estante postEstanteRepository(Estante estante) {
        return estanteRepository.save(estante);
    }
    
}
