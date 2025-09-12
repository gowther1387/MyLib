package com.example.mylib.models;

import com.example.mylib.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "livro_db")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(name = "titulo")
    private String titulo;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @NotBlank
    @Column(name = "categoria")
    private Categoria categoria;

    @Column(name = "lancamento")
    private LocalDateTime lancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estante estante;

    @Column(name = "lido")
    private boolean lido;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDateTime lancamento) {
        this.lancamento = lancamento;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Livro livro)) return false;
        return lido == livro.lido && Objects.equals(id, livro.id) && Objects.equals(titulo, livro.titulo) && Objects.equals(descricao, livro.descricao) && categoria == livro.categoria && Objects.equals(lancamento, livro.lancamento) && Objects.equals(autor, livro.autor) && Objects.equals(estante, livro.estante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, categoria, lancamento, autor, estante, lido);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", lancamento=" + lancamento +
                ", autor=" + autor +
                ", estante=" + estante +
                ", lido=" + lido +
                '}';
    }
}
