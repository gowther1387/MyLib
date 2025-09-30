package com.example.mylib.controllers;

import com.example.mylib.models.User;
import com.example.mylib.services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class UserController {

    private ModelMapper modelMapper ;
    private UserService userService ;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/postUser")
    public User postUser(@Valid @RequestBody User user){
        return userService.postUser(user);
    }

    @GetMapping("/Users")
    public List<User> getAllUser(){
        return userService.getUsers();
    }

/*
    public User loginUser(@Valid @RequestBody String email, String senha){
    }*/
}
