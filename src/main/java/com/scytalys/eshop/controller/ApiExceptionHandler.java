package com.scytalys.eshop.controller;

import com.scytalys.eshop.dto.ApplicationErrorResponse;
import com.scytalys.eshop.exception.EmployeeCannotCreateException;
import com.scytalys.eshop.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex) {
        ErrorResponse errorResponse = new
                ApplicationErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(EmployeeCannotCreateException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeCannotCreateException(EmployeeCannotCreateException ex) {
        ErrorResponse errorResponse = new
                ApplicationErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

}