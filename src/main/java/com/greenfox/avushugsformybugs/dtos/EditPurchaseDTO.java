package com.greenfox.avushugsformybugs.dtos;

import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;

import java.util.List;

public class EditPurchaseDTO {
  PurchaseStatus status;

  List<Long> purchaseIds;

  public EditPurchaseDTO(PurchaseStatus status, List<Long> purchaseIds) {
    this.status = status;
    this.purchaseIds = purchaseIds;
  }

  public PurchaseStatus getStatus() {
    return status;
  }

  public List<Long> getPurchaseIds() {
    return purchaseIds;
  }

  public void setStatus(PurchaseStatus status) {
    this.status = status;
  }

  public void setPurchaseIds(List<Long> purchaseIds) {
    this.purchaseIds = purchaseIds;
  }
}
