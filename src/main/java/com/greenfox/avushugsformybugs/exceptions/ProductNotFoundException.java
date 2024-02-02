package com.greenfox.avushugsformybugs.exceptions;

public class ProductNotFoundException extends Exception {
  public ProductNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
