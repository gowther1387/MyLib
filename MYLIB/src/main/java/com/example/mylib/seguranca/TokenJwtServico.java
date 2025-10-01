package com.example.mylib.seguranca;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.mylib.modelos.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenJwtServico {

    private final String segredo;
    private final long expiracaoMinutos;

    public TokenJwtServico(@Value("${aplicacao.jwt.segredo:segredo-default}") String segredo,
                           @Value("${aplicacao.jwt.expiracao-minutos:60}") long expiracaoMinutos) {
        this.segredo = segredo;
        this.expiracaoMinutos = expiracaoMinutos;
    }

    public String gerarToken(Usuario usuario) {
        Instant agora = Instant.now();
        return JWT.create()
                .withIssuer("mylib-api")
                .withSubject(usuario.getUsername())
                .withIssuedAt(Date.from(agora))
                .withExpiresAt(Date.from(agora.plus(expiracaoMinutos, ChronoUnit.MINUTES)))
                .sign(Algorithm.HMAC256(segredo));
    }

    public String validarToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(segredo))
                    .withIssuer("mylib-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            return null;
        }
    }
}
