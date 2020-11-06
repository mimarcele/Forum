package com.alura.exception;

public class AutenticacaoNotFoundException extends RuntimeException{
    public AutenticacaoNotFoundException(String message){
        super(message);
    }
}
