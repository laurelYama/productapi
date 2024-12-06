package com.example.productapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotExistException exception){
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(),exception.getCode(), exception.getError());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
