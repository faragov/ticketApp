package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.services.ProductService;
import com.greenfox.avushugsformybugs.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

  @Autowired
  private ProductService productService;

  @Autowired
  private PurchaseService purchaseService;

  @PostMapping
  public ResponseEntity<String> createPurchase(@AuthenticationPrincipal User userDetails, @RequestBody List<Long> productIds) {


    Long userId = getUserIdFromUserDetails(userDetails);


    if (userId == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user details");
    }


    Purchase purchase = new Purchase();
    purchase.setStatus(PurchaseStatus.PENDING);


    List<Product> products = productService.getProductsByIds(productIds);


    if (products.size() != productIds.size()) {
      return ResponseEntity.badRequest().body("Invalid product id(s)");
    }


    purchase.setUser(new User(userId));
    purchase.setProduct(products);


    Purchase savedPurchase = purchaseService.savePurchase(purchase);

    if (savedPurchase != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body("Purchase created successfully");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create purchase");
    }
  }
}
