package com.alura.exception;

import com.alura.modelo.Curso;

public class CursoNotFoundException extends RuntimeException{
    public CursoNotFoundException(String message){
        super(message);
    }
}
