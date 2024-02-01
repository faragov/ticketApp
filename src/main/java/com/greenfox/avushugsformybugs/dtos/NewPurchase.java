package com.greenfox.avushugsformybugs.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class NewPurchase {

  @NotNull(message = "product ID can not be empty!")
  private Long productID;

  @Min(value = 1, message = "amount can not be less than 1")
  @Max(value = 10, message = "amount can not be larger than 10")
  private Long amount;

  public NewPurchase() {}

  public NewPurchase(Long productID, Long amount) {
    this.productID = productID;
    this.amount = amount;
  }

  public long getProductID() {
    return productID;
  }

  public void setProductID(long productID) {
    this.productID = productID;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }
}
