package com.example.mylib.configuracao;

import com.example.mylib.seguranca.FiltroAutenticacaoJwt;
import com.example.mylib.seguranca.ServicoDetalhesUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class ConfiguracaoSeguranca {

    private final FiltroAutenticacaoJwt filtroAutenticacaoJwt;
    private final ServicoDetalhesUsuario servicoDetalhesUsuario;

    public ConfiguracaoSeguranca(FiltroAutenticacaoJwt filtroAutenticacaoJwt,
                                 ServicoDetalhesUsuario servicoDetalhesUsuario) {
        this.filtroAutenticacaoJwt = filtroAutenticacaoJwt;
        this.servicoDetalhesUsuario = servicoDetalhesUsuario;
    }

    @Bean
    public SecurityFilterChain cadeiaDeSeguranca(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessao -> sessao.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .userDetailsService(servicoDetalhesUsuario)
                .authorizeHttpRequests(autorizacao -> autorizacao
                        .requestMatchers("/api/autenticacao/login", "/api/usuarios").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(filtroAutenticacaoJwt, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager gerenciadorAutenticacao(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder codificadorSenha() {
        return new BCryptPasswordEncoder();
    }
}
