package com.example.mylib.controladores;

import com.example.mylib.dtos.LoginDto;
import com.example.mylib.dtos.TokenDto;
import com.example.mylib.modelos.Usuario;
import com.example.mylib.seguranca.TokenJwtServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
@Tag(name = "Autenticação", description = "Fluxo de autenticação JWT")
public class AutenticacaoControle {

    private final AuthenticationManager authenticationManager;
    private final TokenJwtServico tokenJwtServico;

    public AutenticacaoControle(AuthenticationManager authenticationManager, TokenJwtServico tokenJwtServico) {
        this.authenticationManager = authenticationManager;
        this.tokenJwtServico = tokenJwtServico;
    }

    @PostMapping("/login")
    @Operation(summary = "Gerar token JWT")
    public ResponseEntity<TokenDto> autenticar(@Valid @RequestBody LoginDto dto) {
        UsernamePasswordAuthenticationToken autenticacao =
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());
        Authentication authentication = authenticationManager.authenticate(autenticacao);
        Usuario usuario = (Usuario) authentication.getPrincipal();
        String token = tokenJwtServico.gerarToken(usuario);
        return ResponseEntity.ok(new TokenDto("Bearer", token));
    }
}
