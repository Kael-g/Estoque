package com.example.gerenciamentoEstoque.exception;

public class ManagementNotFoundException extends RuntimeException{
    public ManagementNotFoundException(Long id){
        super(String.format("Movimentação com id %d não encontrada.", id));
    }
}
