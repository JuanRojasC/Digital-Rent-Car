package com.digital_booking.api_products.exceptions;

import com.digital_booking.api_products.util.Log;
import lombok.extern.log4j.Log4j;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.BeanCreationException;
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
        log.info(Log.formatLog("**RESOURCE NOT FOUND**", ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> DatoInconsistente(Exception ex){
        log.info(Log.formatLog("**PRODUCTS-SERVICE-FAIL**", "Dato Inconsistente en registro" + ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<?> incompleteData(PropertyValueException ex){
        log.info(Log.formatLog("**INCOMPLETE DATA**", ex.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidDateBooking.class)
    public ResponseEntity<?> invalidDateBooking(InvalidDateBooking ex){
        log.info(Log.formatLog("**BOOKINGS-SERVICE-FAIL**", "Las fechas ingresadas no son secuencialmente correctas"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}