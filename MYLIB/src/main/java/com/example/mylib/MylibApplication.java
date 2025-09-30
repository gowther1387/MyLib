package com.example.mylib;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MylibApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(MylibApplication.class, args);
	}

}