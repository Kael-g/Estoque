package com.example.gerenciamentoEstoque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity(name = "tb_produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String nome;

    @NotNull
    @NotBlank
    @NotEmpty
    private String categoria;

    @NotNull
    @NotBlank
    @NotEmpty
    private String descricao;

    @Positive
    private BigDecimal valor;

    @PositiveOrZero
    private Integer quantidade;

    public ProdutoModel(String nome, String categoria, String descricao, BigDecimal valor, Integer quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }
}
