package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;

import java.util.List;
import java.util.Set;

public interface PurchaseService {

  Set<Purchase> findPurchaseByUserIdAndStatus(Long userId, PurchaseStatus status);

  void checkStatus(PurchaseStatus status);

  List<PurchaseDto> getPurchaseDtos(Long userId, PurchaseStatus status);
}
