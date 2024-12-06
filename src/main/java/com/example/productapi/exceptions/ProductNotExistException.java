package com.example.productapi.exceptions;

public class ProductNotExistException extends BaseException{
    public ProductNotExistException(String error, String code, String message) {
        super(error, code, message);
    }
}
