package com.example.gerenciamentoEstoque.model.factory;

public class CalculoEntrada implements CalculoQuantidade{
    @Override
    public Integer calculo(Integer quantidadeAtual, Integer quantidadeMovimentada) {
        return quantidadeAtual + quantidadeMovimentada;
    }
}
