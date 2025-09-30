package com.example.mylib.repositories;

import com.example.mylib.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUsersById(Long id);

    User findByUsername(String username);


}
