package com.algaworks.osworks.api.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;

//@ControllerAdvice componente que trata as exceptions

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    //MessageSource é uma interfase do Spring usada pra resolver messages.propertis
    //MessageSource precisa da @Autowired pra atribur uma instancia na variável messageSource
    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers,
             HttpStatus status, WebRequest request) {
        var campos = new ArrayList<RespostaProblema.Campo>();

        for(ObjectError error:ex.getBindingResult().getAllErrors()) {
            //String nome = error.getObjectName();
            String nome = ((FieldError)error).getField();
//            String mensagemCampo = error.getDefaultMessage();
            //LocalContextHolder pega a lingua e o idioma local.
            String mensagemCampo = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new RespostaProblema.Campo(nome, mensagemCampo));
        }

        var respostaproblema = new RespostaProblema();
        respostaproblema.setStatus(status.value());
        respostaproblema.setMensagem("Um o mais campos estão inválidos. "
                        + "Faça o preenchimento correto e tente novamente");
        respostaproblema.setDataHora(LocalDateTime.now());
        respostaproblema.setCampos(campos);

        return super.handleExceptionInternal(ex, respostaproblema, headers, status, request);
    }
}
