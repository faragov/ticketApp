package com.greenfox.avushugsformybugs.dtos;



public class NewPurchase {


    private Long productID;


    private Long amount;


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
