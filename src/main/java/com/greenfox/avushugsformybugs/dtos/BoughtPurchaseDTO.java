package com.greenfox.avushugsformybugs.dtos;

import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;

import java.util.Date;

public class BoughtPurchaseDTO {
  private Long id;
  private PurchaseStatus status;
  private Date activateDate;
  private BoughtProductDTO product;

  public BoughtPurchaseDTO() {
  }

  public BoughtPurchaseDTO(Long id, PurchaseStatus status, Date activateDate, BoughtProductDTO product) {
    this.id = id;
    this.status = status;
    this.activateDate = activateDate;
    this.product = product;
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

  public Date getActivateDate() {
    return activateDate;
  }

  public void setActivateDate(Date activateDate) {
    this.activateDate = activateDate;
  }

  public BoughtProductDTO getProduct() {
    return product;
  }

  public void setProduct(BoughtProductDTO product) {
    this.product = product;
  }
}
