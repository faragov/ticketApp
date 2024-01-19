package com.greenfox.avushugsformybugs.dtos;

import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;

import java.util.Date;

public class PurchaseDto {

    private Long id;
    private PurchaseStatus status;
    private Date orderDate;
    private Date activateDate;
    private String productName;
    private int productPrice;
    private int productDuration;
    private String productType;

    public PurchaseDto() {
    }

    public PurchaseDto(Long id, PurchaseStatus status, Date orderDate, Date activateDate, String productName, int productPrice, int productDuration, String productType) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.activateDate = activateDate;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDuration = productDuration;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductDuration() {
        return productDuration;
    }

    public void setProductDuration(int productDuration) {
        this.productDuration = productDuration;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
