package com.example.gerenciamentoEstoque.exception;

public class InvalidTypeArgumentException extends IllegalArgumentException{
    public InvalidTypeArgumentException(){
        super("Tipo de movimentação inválida. Tipos suportados: [entrada / saída]");
    }
}
