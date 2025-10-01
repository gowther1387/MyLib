package com.example.mylib.configuracao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "MyLib API",
                version = "1.0",
                description = "API para gerenciamento de bibliotecas, autores, livros e usuários",
                contact = @Contact(name = "Equipe MyLib", email = "contato@mylib.com")
        )
)
public class ConfiguracaoSwagger {
}
