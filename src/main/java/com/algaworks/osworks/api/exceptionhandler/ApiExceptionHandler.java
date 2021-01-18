package com.algaworks.osworks.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

//@ControllerAdvice componente que trata as exceptions

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers,
             HttpStatus status, WebRequest request) {

        var respostaproblema = new RespostaProblema();
        respostaproblema.setStatus(status.value());
        respostaproblema.setMensagem("Um o mais campos estão inválidos. "
                        + "Faça o preenchimento correto e tente novamente");
        respostaproblema.setDataHora(LocalDateTime.now());

        return super.handleExceptionInternal(ex, respostaproblema, headers, status, request);
    }
}
