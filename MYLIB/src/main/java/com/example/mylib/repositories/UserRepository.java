package com.example.mylib.repositories;

import com.example.mylib.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User getUsersById(UUID id);

    User findByNome(String nome);

    User findByEmail(String email);

}
