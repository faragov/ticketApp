package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.services.ProductService;
import com.greenfox.avushugsformybugs.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/purchase")
public class PurchaseController {

  @Autowired
  private ProductService productService;

  @Autowired
  private PurchaseService purchaseService;

  @PostMapping
  public ResponseEntity<String> createPurchase(@RequestBody NewPurchase newPurchase, @AuthenticationPrincipal User user) {

    Long userId = user.getId();

    if (!isValidPurchaseRequest(newPurchase)) {
      return ResponseEntity.badRequest().body("Invalid purchase request.");
    }


    try{
      productService.findById(newPurchase.getProductID());
    }
    catch (IllegalArgumentException e){
      return ResponseEntity.badRequest().body("Invalid product ID.");
    }

    purchaseService.createPurchase(userId, newPurchase.getAmount());


    return ResponseEntity.ok("Purchase successful.");
  }

  private boolean isValidPurchaseRequest(NewPurchase newPurchase) {
      if (newPurchase != null && newPurchase.getAmount() > 0 && newPurchase.getAmount() <= 10) {
          newPurchase.getProductID();
      }
      return false;
  }
}
