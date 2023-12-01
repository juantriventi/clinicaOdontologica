package com.backend.clinicaOdontologica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException extends Exception{

    @ExceptionHandler
    @ResponseStatus
    public Map<String, String> sourceNotFoundHandler(ResourceNotFoundException exception){
        Map<String, String> error = new HashMap<>();
        error.put("error","Recurso no encontrado: " + exception.getMessage());
        return error;
    }

    @ExceptionHandler
    @ResponseStatus
    public Map<String, String> badRequestHandler(BadRequestException exception){
        Map<String, String> error = new HashMap<>();
        error.put("error","Bad request: " + exception.getMessage());
        return error;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> validationExceptionHandler(MethodArgumentNotValidException exception) {
        Map<String, String> exceptionMessage = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            exceptionMessage.put(fieldName, errorMessage);
        });

        return exceptionMessage;
    }


}
