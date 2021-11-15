package com.digital_booking.api_images.exceptions;

import lombok.extern.log4j.Log4j;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> allErrors(Exception ex, WebRequest req){
//        log.error("Error general ["+ex.getLocalizedMessage()+"]");
//        System.out.println(ex);
//        return new ResponseEntity<>("Error: " + ex.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> resourceNotFound(ResourceNotFound ex){
        log.error("Error en búsqueda ["+ex.getMessage()+"]");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> DatoInconsistente(Exception ex){
        log.error("Dato Inconsistente en registro ["+ex.getLocalizedMessage()+"]");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<?> incompleteData(PropertyValueException ex){
        log.error("Campos incompletos en el request");
        String message = "title and urlImage attributes can not be null";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}