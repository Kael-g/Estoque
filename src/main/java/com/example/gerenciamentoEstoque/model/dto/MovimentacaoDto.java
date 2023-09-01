package com.example.gerenciamentoEstoque.model.dto;

import com.example.gerenciamentoEstoque.model.MovimentacaoModel;
import com.example.gerenciamentoEstoque.model.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoDto {
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    private Date data;

    @NotNull(message = "É necessário inserir a quantidade a ser movimentada")
    @Positive(message = "Quantidade deve ser um valor inteiro positivo")
    private Integer quantidadeMovimentada;

    private Integer quantidadeFinal;

    @NotBlank(message = "É necessário inserir o tipo de movimentação")
    private String tipo;

    private String status;

    public MovimentacaoDto(MovimentacaoModel movimentacao) {
        this.id = movimentacao.getId();
        this.produto = movimentacao.getProduto();
        this.data = movimentacao.getData();
        this.quantidadeMovimentada = movimentacao.getQuantidadeMovimentada();
        this.quantidadeFinal = movimentacao.getQuantidadeFinal();
        this.tipo = movimentacao.getTipo();
        this.status = movimentacao.getStatus();
    }

    public MovimentacaoDto(ProdutoModel produto, Integer quantidadeMovimentada, String tipo) {
        this.produto = produto;
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.tipo = tipo;
    }
}
