package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.ErrorMessage;
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
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorMessage("Product not found"));
  }
  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception){
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorMessage("Illegal status"));
  }
}
