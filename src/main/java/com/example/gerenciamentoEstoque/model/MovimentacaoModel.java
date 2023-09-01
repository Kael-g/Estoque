package com.example.gerenciamentoEstoque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity(name = "tb_movimentacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Positive
    private Integer quantidadeMovimentada;

    private Integer quantidadeFinal;

    @NotEmpty
    @NotNull
    @NotBlank
    private String tipo;

    private String status;

    public MovimentacaoModel(ProdutoModel produto, Integer quantidadeMovimentada, Integer quantidadeFinal, String tipo, String status) {
        this.produto = produto;
        this.data = new Date();
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.quantidadeFinal = quantidadeFinal;
        this.tipo = tipo;
        this.status = status;
    }

    public MovimentacaoModel(ProdutoModel produto, Integer quantidadeMovimentada, String tipo,String status) {
        this.produto = produto;
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.quantidadeFinal = quantidadeMovimentada;
        this.tipo = tipo;
        this.status = status;
    }
}
