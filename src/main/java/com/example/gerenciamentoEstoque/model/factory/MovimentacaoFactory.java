package com.example.gerenciamentoEstoque.model.factory;

import com.example.gerenciamentoEstoque.exception.InvalidTypeArgumentException;

public class MovimentacaoFactory {

    public CalculoQuantidade tipoMovimentacao(String movimentacao){
        if (movimentacao.equalsIgnoreCase("entrada")){
            return new CalculoEntrada();
        } else if (movimentacao.equalsIgnoreCase("saida") || movimentacao.equalsIgnoreCase("saída")) {
            return new CalculoSaida();
        }else {
            throw  new InvalidTypeArgumentException();
        }
    }
}
