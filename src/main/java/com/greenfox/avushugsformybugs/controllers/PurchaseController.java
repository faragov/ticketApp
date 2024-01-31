package com.greenfox.avushugsformybugs.controllers;


import com.greenfox.avushugsformybugs.dtos.EditPurchaseDTO;
import com.greenfox.avushugsformybugs.dtos.ErrorMessage;
import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.dtos.SuccessMessage;
import com.greenfox.avushugsformybugs.exceptions.IllegalPurchaseStatusException;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.services.ProductService;
import com.greenfox.avushugsformybugs.services.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.greenfox.avushugsformybugs.dtos.ErrorMessage;
import com.greenfox.avushugsformybugs.models.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PurchaseController {

  @Autowired
  private ProductService productService;

  @Autowired
  private PurchaseService purchaseService;

  @PostMapping("/purchases")
  public ResponseEntity createPurchase(@Valid @RequestBody NewPurchase newPurchase, @AuthenticationPrincipal User user) throws ProductNotFoundException{
    purchaseService.createPurchase(user, newPurchase);
    return ResponseEntity.ok(new SuccessMessage("Successful purchase"));
  }

  @GetMapping("/purchases")
  public ResponseEntity showAllPurchases(@AuthenticationPrincipal User loginedUser, @RequestParam(required = false) PurchaseStatus status) {
    if (status == null) {
      status = PurchaseStatus.PENDING;
    }
    if (!purchaseService.findPurchaseByUserIdAndStatus(loginedUser.getId(), status).isEmpty()) {
      return ResponseEntity.status(201).body(purchaseService.getPurchaseDtos(loginedUser.getId(), status));
    } else {
      return ResponseEntity.status(201).body("No result");
    }
  }

  @PutMapping("/api/purchases")
  public ResponseEntity modifyPurchases(@AuthenticationPrincipal User loginedUser, @RequestBody EditPurchaseDTO editPurchase) throws IllegalPurchaseStatusException {
    purchaseService.checkStatus(editPurchase.getStatus());
    purchaseService.editPurchases(loginedUser.getId(),editPurchase);
    SuccessMessage successMessage = new SuccessMessage("Success");
    return ResponseEntity.status(200).body(successMessage);
  }
}