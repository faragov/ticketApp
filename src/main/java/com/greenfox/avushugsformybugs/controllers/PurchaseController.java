package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

  private final PurchaseService purchaseService;

  @Autowired
  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }
}
