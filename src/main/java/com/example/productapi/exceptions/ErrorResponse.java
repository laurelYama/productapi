package com.example.productapi.exceptions;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ErrorResponse {
    private String message;
    private String code;
    private String error;
    private LocalDateTime date;

    public ErrorResponse(String message, String code, String error) {
        this.message = message;
        this.code = code;
        this.error = error;
        this.date = LocalDateTime.now();
    }
}
