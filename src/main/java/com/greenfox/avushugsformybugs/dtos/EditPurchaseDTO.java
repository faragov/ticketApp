package com.greenfox.avushugsformybugs.dtos;

import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;

import java.util.List;

public class EditPurchaseDTO {
  String status;

  List<Long> purchaseIds;

  public EditPurchaseDTO(String status, List<Long> purchaseIds) {
    this.status=status;
    this.purchaseIds = purchaseIds;
  }

  public String getStatus() {
    return status;
  }

  public List<Long> getPurchaseIds() {
    return purchaseIds;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setPurchaseIds(List<Long> purchaseIds) {
    this.purchaseIds = purchaseIds;
  }
}
