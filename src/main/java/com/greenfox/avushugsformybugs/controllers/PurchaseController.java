package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.EditPurchaseDTO;
import com.greenfox.avushugsformybugs.dtos.ErrorMessage;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {

  private final PurchaseService purchaseService;

  @Autowired
  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @GetMapping("/api/purchases")
  public ResponseEntity showAllPurchases(@AuthenticationPrincipal User loginedUser, @RequestParam(required = false) PurchaseStatus status) {
    try {
      if (status == null) {
        status = PurchaseStatus.PENDING;
      }
      if (!purchaseService.findPurchaseByUserIdAndStatus(loginedUser.getId(), status).isEmpty()) {
        return ResponseEntity.status(201).body(purchaseService.getPurchaseDtos(loginedUser.getId(), status));
      } else {
        return ResponseEntity.status(201).body("No result");
      }
    } catch (IllegalArgumentException e) {
      ErrorMessage errorMessage = new ErrorMessage("Unknown status");
      return ResponseEntity.status(400).body(errorMessage);
    }
  }

  @PutMapping("/api/purchases")
  public ResponseEntity modifyPurchases(@AuthenticationPrincipal User loginedUser, @RequestBody EditPurchaseDTO editPurchase){
    try{
      purchaseService.checkStatus(editPurchase.getStatus());
    } catch(IllegalArgumentException e){
      ErrorMessage errorMessage = new ErrorMessage("Unknown status");
      return ResponseEntity.status(400).body(errorMessage);
    }
    purchaseService.editPurchases(loginedUser.getId(),editPurchase);
    return ResponseEntity.status(200).body("success");
  }
}