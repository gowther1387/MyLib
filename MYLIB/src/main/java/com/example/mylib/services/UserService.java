package com.example.mylib.services;


import com.example.mylib.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

private final UserRepository userRepository;

public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}



}
