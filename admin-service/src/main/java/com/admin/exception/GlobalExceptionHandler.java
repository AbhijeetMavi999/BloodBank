package com.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAdminNotFoundException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
