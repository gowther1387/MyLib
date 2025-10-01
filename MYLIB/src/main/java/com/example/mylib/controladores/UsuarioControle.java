package com.example.mylib.controladores;

import com.example.mylib.dtos.UsuarioCadastroDto;
import com.example.mylib.dtos.UsuarioRespostaDto;
import com.example.mylib.servicos.UsuarioServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Gerenciamento de usuários da aplicação")
public class UsuarioControle {

    private final UsuarioServico usuarioServico;

    public UsuarioControle(UsuarioServico usuarioServico) {
        this.usuarioServico = usuarioServico;
    }

    @PostMapping
    @Operation(summary = "Registrar usuário")
    public ResponseEntity<UsuarioRespostaDto> registrarUsuario(@Valid @RequestBody UsuarioCadastroDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServico.registrarUsuario(dto));
    }

    @GetMapping
    @Operation(summary = "Listar usuários")
    public ResponseEntity<List<UsuarioRespostaDto>> listarUsuarios() {
        return ResponseEntity.ok(usuarioServico.listarUsuarios());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por identificador")
    public ResponseEntity<UsuarioRespostaDto> buscarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServico.buscarUsuarioPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuário")
    public ResponseEntity<UsuarioRespostaDto> atualizarUsuario(@PathVariable Long id,
                                                               @Valid @RequestBody UsuarioCadastroDto dto) {
        return ResponseEntity.ok(usuarioServico.atualizarUsuario(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover usuário")
    public void removerUsuario(@PathVariable Long id) {
        usuarioServico.removerUsuario(id);
    }
}
