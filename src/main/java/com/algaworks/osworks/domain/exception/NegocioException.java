package com.algaworks.osworks.domain.exception;

public class NegocioException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    //Código feito pra tratar erros de negócios
    //A classe super é o RunTimeException

    //Isto é o constructor da Exception
    public NegocioException(String message){
        super(message);
    }
}
