package com.greenfox.avushugsformybugs.exceptions;

public class IllegalPurchaseStatusException extends Exception{
  public IllegalPurchaseStatusException(String errorMessage){
    super(errorMessage);
  }
}
