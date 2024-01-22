package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.services.ProductService;
import com.greenfox.avushugsformybugs.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

  @Autowired
  private ProductService productService;

  @Autowired
  private PurchaseService purchaseService;

  @PostMapping
  public ResponseEntity<String> createPurchase(@RequestBody NewPurchase newPurchase) {

    String userId = SecurityContextHolder.getContext().getAuthentication().getName();


    if (!isValidPurchaseRequest(newPurchase)) {
      return ResponseEntity.badRequest().body("Invalid purchase request.");
    }

    Product product = productService.findById(newPurchase.getProductID()).orElse(null);

    if (product == null) {
      return ResponseEntity.badRequest().body("Invalid product ID.");
    }


    List<Purchase> purchases = new ArrayList<>();
    for (int i = 0; i < newPurchase.getAmount(); i++) {
      Purchase purchase = new Purchase();
      purchase.setId(Long.valueOf(userId));
      purchase.setProduct(product);
      PurchaseStatus.valueOf("PENDING");
      purchases.add(purchase);
    }

    purchaseService.saveAll(purchases);

    return ResponseEntity.ok("Purchase successful.");
  }

  private boolean isValidPurchaseRequest(NewPurchase newPurchase) {
      if (newPurchase != null && newPurchase.getAmount() > 0 && newPurchase.getAmount() <= 10) {
          newPurchase.getProductID();
      }
      return false;
  }
}
