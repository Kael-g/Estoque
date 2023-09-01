package com.example.gerenciamentoEstoque.model.dto;

import com.example.gerenciamentoEstoque.model.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoDto {
    private Long id;

    @NotBlank(message = "É necessário inserir o nome do produto")
    private String nome;

    @NotBlank(message = "É necessário inserir a categoria do produto")
    private String categoria;

    @NotBlank(message = "É necessário inserir a descrição do produto")
    private String descricao;

    @Positive(message = "Valor do produto deve ser positivo")
    private BigDecimal valor;

    @PositiveOrZero(message = "Quantidade do produto não pode ser um valor negativo")
    private Integer quantidade;

    public ProdutoDto(ProdutoModel produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
    }

    public ProdutoDto(String nome, String categoria, String descricao, BigDecimal valor, Integer quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }
}
