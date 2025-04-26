package com.itb.tcc.mif3an.greencode.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;

//@ControllerAdvice:Toda vez que ocorrer algum erro, este controller será acionado. é uma classe para tratamento de erro.
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    ZoneId zoneIdBrasil = ZoneId.of("America/Sao_Paulo");

    String[] arrayMessage;

    @ExceptionHandler
    public ResponseEntity<Object> globalException(Exception ex) {
        LocalDateTime localDateTimeBrasil = LocalDateTime.now(zoneIdBrasil);
        String errorMessageDescription = ex.getLocalizedMessage();
        System.out.println(errorMessageDescription);
        errorMessageDescription = "Ocorreu um erro interno no servidor:";

        arrayMessage = errorMessageDescription.split(":");
        ErrorMessage errorMessage = new ErrorMessage(localDateTimeBrasil, arrayMessage, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class})
    public ResponseEntity<Object> badRequestException(HttpClientErrorException.BadRequest ex) {
        LocalDateTime localDateTimeBrasil = LocalDateTime.now(zoneIdBrasil);
        String errorMessageDescription = ex.getLocalizedMessage();
        System.out.println(errorMessageDescription);
        errorMessageDescription = "Ocorreu um erro interno no servidor:";

        arrayMessage = errorMessageDescription.split(":");
        ErrorMessage errorMessage = new ErrorMessage(localDateTimeBrasil, arrayMessage, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

    }
}

