package com.greenfox.avushugsformybugs.exceptions;

public class PurchaseNotFoundException extends RuntimeException {
  public PurchaseNotFoundException(String message) {
    super(message);
  }
}
