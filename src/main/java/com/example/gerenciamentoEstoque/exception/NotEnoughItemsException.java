package com.example.gerenciamentoEstoque.exception;

public class NotEnoughItemsException extends RuntimeException{
    public NotEnoughItemsException(Integer quantidade){
        super(String.format("Itens insuficientes. Quantidade disponível: %d", quantidade));
    }
}
