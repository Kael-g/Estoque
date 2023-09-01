package com.example.gerenciamentoEstoque.model.factory;

public interface CalculoQuantidade {
    Integer calculo(Integer quantidadeAtual, Integer quantidadeMovimentada);
}
