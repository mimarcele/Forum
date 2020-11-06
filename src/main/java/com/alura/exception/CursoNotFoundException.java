package com.alura.exception;

public class CursoNotFoundException extends RuntimeException{
    public CursoNotFoundException(String message){
        super(message);
    }
}
