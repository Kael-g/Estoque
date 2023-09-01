package com.example.gerenciamentoEstoque.model.factory;

import com.example.gerenciamentoEstoque.exception.NotEnoughItemsException;

public class CalculoSaida implements CalculoQuantidade{
    @Override
    public Integer calculo(Integer quantidadeAtual, Integer quantidadeMovimentada) {
        if (quantidadeMovimentada>quantidadeAtual){
            throw new NotEnoughItemsException(quantidadeAtual);
        } else {
            return quantidadeAtual - quantidadeMovimentada;
        }
    }
}
