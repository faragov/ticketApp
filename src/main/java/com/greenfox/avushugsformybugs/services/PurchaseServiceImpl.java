package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseRepository purchaseRepository;

  @Autowired
  public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }
}
