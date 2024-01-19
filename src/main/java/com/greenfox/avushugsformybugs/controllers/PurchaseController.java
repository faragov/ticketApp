package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.ErrorMessage;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.greenfox.avushugsformybugs.models.enums.PurchaseStatus.PENDING;

@RestController
public class PurchaseController {

  private final PurchaseService purchaseService;

  @Autowired
  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @GetMapping("/api/purchases")
  public ResponseEntity showAllPurchases(@AuthenticationPrincipal User loginedUser, @RequestParam(required = false, defaultValue = PENDING) PurchaseStatus status) {
    ErrorMessage errormessage = new ErrorMessage();
    if (!purchaseService.findPurchaseByUserIdAndStatus(loginedUser.getId(), status.getStatus()).isEmpty()) {
      return ResponseEntity.status(201).body(purchaseService.getPurchaseDtos(loginedUser.getId(), status.getStatus())));
    } else {
      return ResponseEntity.status(400).body(errormessage);
    }
  }
}