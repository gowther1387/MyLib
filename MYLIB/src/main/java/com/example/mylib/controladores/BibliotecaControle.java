package com.example.mylib.controladores;

import com.example.mylib.dtos.BibliotecaCadastroDto;
import com.example.mylib.dtos.BibliotecaRespostaDto;
import com.example.mylib.servicos.BibliotecaServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
@Tag(name = "Bibliotecas", description = "Operações de gerenciamento de bibliotecas")
public class BibliotecaControle {

    private final BibliotecaServico bibliotecaServico;

    public BibliotecaControle(BibliotecaServico bibliotecaServico) {
        this.bibliotecaServico = bibliotecaServico;
    }

    @PostMapping
    @Operation(summary = "Cadastrar biblioteca")
    public ResponseEntity<BibliotecaRespostaDto> cadastrarBiblioteca(@Valid @RequestBody BibliotecaCadastroDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaServico.criarBiblioteca(dto));
    }

    @GetMapping
    @Operation(summary = "Listar bibliotecas")
    public ResponseEntity<List<BibliotecaRespostaDto>> listarBibliotecas() {
        return ResponseEntity.ok(bibliotecaServico.listarBibliotecas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar biblioteca por identificador")
    public ResponseEntity<BibliotecaRespostaDto> buscarBiblioteca(@PathVariable Long id) {
        return ResponseEntity.ok(bibliotecaServico.buscarBibliotecaPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar biblioteca")
    public ResponseEntity<BibliotecaRespostaDto> atualizarBiblioteca(@PathVariable Long id,
                                                                     @Valid @RequestBody BibliotecaCadastroDto dto) {
        return ResponseEntity.ok(bibliotecaServico.atualizarBiblioteca(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover biblioteca")
    public void removerBiblioteca(@PathVariable Long id) {
        bibliotecaServico.removerBiblioteca(id);
    }

    @PostMapping("/{id}/livros/{livroId}")
    @Operation(summary = "Adicionar livro à biblioteca")
    public ResponseEntity<BibliotecaRespostaDto> adicionarLivro(@PathVariable Long id, @PathVariable Long livroId) {
        return ResponseEntity.ok(bibliotecaServico.adicionarLivro(id, livroId));
    }

    @PostMapping("/{id}/usuarios/{usuarioId}")
    @Operation(summary = "Associar usuário à biblioteca")
    public ResponseEntity<BibliotecaRespostaDto> associarUsuario(@PathVariable Long id, @PathVariable Long usuarioId) {
        return ResponseEntity.ok(bibliotecaServico.associarUsuario(id, usuarioId));
    }
}
