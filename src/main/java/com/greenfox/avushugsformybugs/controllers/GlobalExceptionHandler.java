package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.ErrorMessage;
import com.greenfox.avushugsformybugs.exceptions.IllegalPurchaseStatusException;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.exceptions.PurchaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler({ProductNotFoundException.class})
  public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorMessage(exception.getMessage()));
  }

  @ExceptionHandler({IllegalPurchaseStatusException.class})
  public ResponseEntity<Object> handleIllegalPurchaseStatusException(IllegalPurchaseStatusException exception) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorMessage(exception.getMessage()));
  }

  @ExceptionHandler({PurchaseNotFoundException.class})
  public ResponseEntity<Object> handlePurchaseNotFoundException(PurchaseNotFoundException exception) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorMessage(exception.getMessage()));
  }
}
