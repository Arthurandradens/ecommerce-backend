package br.com.ecommerce.orders.exception;

import br.com.ecommerce.orders.exception.productExeptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(createResponse(exception,HttpStatus.NOT_FOUND));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldError>> handleEmptyFieldsException(MethodArgumentNotValidException ex){
        List<FieldError> errorList = new ArrayList<>();
        for (org.springframework.validation.FieldError error : ex.getFieldErrors()){
            errorList.add(new FieldError(error.getField(),error.getDefaultMessage()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }

    public ErrorMessage createResponse(RuntimeException e,HttpStatus status){
        return new ErrorMessage(
                e.getClass().getName(),
                e.getMessage(),
                status.value(),
                LocalDateTime.now());
    }

    public record FieldError(
            String field,
            String message
    ){
    }


}

