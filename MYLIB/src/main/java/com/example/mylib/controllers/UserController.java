package com.example.mylib.controllers;

import com.example.mylib.models.User;
import com.example.mylib.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/postUser")
    public User postUser(@Valid @RequestBody User user){
        return userService.postUser(user);
    }

    public List<User> getAllUser(){
        return userService.getUsers();
    }
/*
    public User loginUser(@Valid @RequestBody String email, String senha){
    }*/
}
