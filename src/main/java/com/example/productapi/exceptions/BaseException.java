package com.example.productapi.exceptions;

import lombok.Data;
import org.hibernate.internal.build.AllowNonPortable;

 @Data
public class BaseException extends RuntimeException {
    private  String error;
    private  String code;

    public BaseException(String error, String code, String message) {
        super(message);
        this.error = error;
        this.code = code;
    }
}
