package com.digital_booking.api_user.exceptions;

import com.digital_booking.api_user.util.Log;
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

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> resourceNotFound(ResourceNotFound ex){
        log.info(Log.formatLog("**USER-SERVICE-FAIL**", "Busqueda sin resultados " + ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> DatoInconsistente(Exception ex){
        log.info(Log.formatLog("**USER-SERVICE-FAIL**", "Error en el JSON, reviselo e intente nuevamente"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<?> incompleteData(PropertyValueException ex){
        log.info(Log.formatLog("**USER-SERVICE-FAIL**", "Error en el JSON " + ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UserExists.class)
    public ResponseEntity<?> UserAlreadyExists(UserExists ex){
        log.info(Log.formatLog("**USER-SERVICE-FAIL**", "El usuario ya existe " + ex.getMessage()));
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}