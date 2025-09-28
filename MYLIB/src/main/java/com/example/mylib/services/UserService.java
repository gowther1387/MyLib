package com.example.mylib.services;


import com.example.mylib.models.User;
import com.example.mylib.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

private final UserRepository userRepository;

public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}

public User postUser(User user){
    return userRepository.save(user);
}


public User getUser(UUID id){
    return userRepository.getUsersById(id);
}

public List<User> getUsers(){
    return userRepository.findAll();
}

public void deleteUser(UUID id){
    userRepository.deleteById(id);
}

}
