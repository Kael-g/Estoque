package com.example.gerenciamentoEstoque.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoAlterarDto {
    private String nome;

    private String categoria;

    private String descricao;

    @Positive(message = "Valor do produto deve ser positivo")
    private BigDecimal valor;

    @PositiveOrZero(message = "Quantidade do produto não pode ser um valor negativo")
    private Integer quantidade;
}
