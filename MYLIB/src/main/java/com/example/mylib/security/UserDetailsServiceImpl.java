package com.example.mylib.security;

import com.example.mylib.models.User;
import com.example.mylib.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(email);
        if(u == null){
            throw new UsernameNotFoundException(email);
        }
        UserDetails user = org.springframework.security.core.userdetails.User.withUsername(u.getEmail()).password(u.getSenha()).authorities("USER").build();
        return user;
    }
}