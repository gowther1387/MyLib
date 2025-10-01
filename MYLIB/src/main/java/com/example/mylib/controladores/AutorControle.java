package com.example.mylib.controladores;

import com.example.mylib.dtos.AutorCadastroDto;
import com.example.mylib.dtos.AutorRespostaDto;
import com.example.mylib.servicos.AutorServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@Tag(name = "Autores", description = "Operações de cadastro e consulta de autores")
public class AutorControle {

    private final AutorServico autorServico;

    public AutorControle(AutorServico autorServico) {
        this.autorServico = autorServico;
    }

    @PostMapping
    @Operation(summary = "Cadastrar autor")
    public ResponseEntity<AutorRespostaDto> cadastrarAutor(@Valid @RequestBody AutorCadastroDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorServico.criarAutor(dto));
    }

    @GetMapping
    @Operation(summary = "Listar autores")
    public ResponseEntity<List<AutorRespostaDto>> listarAutores() {
        return ResponseEntity.ok(autorServico.listarAutores());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar autor por identificador")
    public ResponseEntity<AutorRespostaDto> buscarAutor(@PathVariable Long id) {
        return ResponseEntity.ok(autorServico.buscarAutorPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar autor")
    public ResponseEntity<AutorRespostaDto> atualizarAutor(@PathVariable Long id,
                                                           @Valid @RequestBody AutorCadastroDto dto) {
        return ResponseEntity.ok(autorServico.atualizarAutor(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover autor")
    public void removerAutor(@PathVariable Long id) {
        autorServico.removerAutor(id);
    }
}
