package com.med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmpireDefender {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity blasterError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity blasterError400(MethodArgumentNotValidException e){
        var message = e.getFieldErrors();

        return ResponseEntity.badRequest().body(message.stream().map(YodaErroValida::new).toList());
    }

    private record YodaErroValida(String campo, String mensagem){
        public YodaErroValida(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
