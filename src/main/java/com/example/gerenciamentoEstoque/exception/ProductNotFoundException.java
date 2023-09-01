package com.example.gerenciamentoEstoque.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super(String.format("Produto com id %d não encontrado.", id));
    }
    public ProductNotFoundException(String nome){
        super(String.format("Produto %s não encontrado. Verifique se foi escrito corretamente.", nome));
    }

}
