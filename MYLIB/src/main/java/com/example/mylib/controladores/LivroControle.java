package com.example.mylib.controladores;

import com.example.mylib.dtos.LivroCadastroDto;
import com.example.mylib.dtos.LivroRespostaDto;
import com.example.mylib.servicos.LivroServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
@Tag(name = "Livros", description = "Operações para gerenciamento de livros")
public class LivroControle {

    private final LivroServico livroServico;

    public LivroControle(LivroServico livroServico) {
        this.livroServico = livroServico;
    }

    @PostMapping
    @Operation(summary = "Cadastrar livro")
    public ResponseEntity<LivroRespostaDto> cadastrarLivro(@Valid @RequestBody LivroCadastroDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroServico.criarLivro(dto));
    }

    @GetMapping
    @Operation(summary = "Listar livros com filtros opcionais")
    public ResponseEntity<List<LivroRespostaDto>> listarLivros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Long autorId,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "Formato esperado: yyyy-MM-dd") LocalDate dataLancamento) {
        return ResponseEntity.ok(livroServico.listarLivros(titulo, autorId, categoria, dataLancamento));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro por identificador")
    public ResponseEntity<LivroRespostaDto> buscarLivro(@PathVariable Long id) {
        return ResponseEntity.ok(livroServico.buscarLivroPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar livro")
    public ResponseEntity<LivroRespostaDto> atualizarLivro(@PathVariable Long id,
                                                           @Valid @RequestBody LivroCadastroDto dto) {
        return ResponseEntity.ok(livroServico.atualizarLivro(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover livro")
    public void removerLivro(@PathVariable Long id) {
        livroServico.removerLivro(id);
    }
}
