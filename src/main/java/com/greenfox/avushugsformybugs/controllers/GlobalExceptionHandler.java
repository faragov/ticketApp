package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler({ProductNotFoundException.class})
  public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception){
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(exception.getMessage());
  }
}
