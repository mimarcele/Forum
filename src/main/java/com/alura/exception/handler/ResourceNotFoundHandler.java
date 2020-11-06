package com.alura.exception.handler;

import com.alura.exception.ResourceNotFoundException;
import com.alura.exception.TopicoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ResourceNotFoundHandler {
  @ExceptionHandler(TopicoNotFoundException.class)
    public ResponseEntity<?> handleResource(TopicoNotFoundException exception){
      ResourceNotFoundException resourceNotFoundException = ResourceNotFoundException.ResourceNotFoundExceptionBuilder.newBuilder()
              .timestamp(new Date().getTime())
              .status(HttpStatus.NOT_FOUND.value())
              .details(exception.getMessage())
              .build();

      return new ResponseEntity<>(resourceNotFoundException, HttpStatus.NOT_FOUND);
  }

}
