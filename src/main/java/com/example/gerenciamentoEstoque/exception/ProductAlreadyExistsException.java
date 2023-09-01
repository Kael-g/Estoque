package com.example.gerenciamentoEstoque.exception;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException(String nome, Long id){
        super(String.format("O produto %s já está registrado com o id %d.", nome, id));
    }
}
