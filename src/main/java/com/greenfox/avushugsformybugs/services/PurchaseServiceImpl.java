package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditPurchaseDTO;
import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.exceptions.IllegalPurchaseStatusException;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.exceptions.PurchaseNotFoundException;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseRepository purchaseRepository;
  private final ProductService productService;

  @Autowired
  public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ProductService productService) {
    this.purchaseRepository = purchaseRepository;
    this.productService = productService;
  }

  @Override
  public PurchaseStatus getPurchaseStatus(String status) throws IllegalPurchaseStatusException {
    String statusToCheck = status.toUpperCase();
    if (!(statusToCheck.equals(PurchaseStatus.ACTIVE.name()) || statusToCheck.equals(PurchaseStatus.USED.name()) || statusToCheck.equals(PurchaseStatus.PENDING.name()) || statusToCheck.equals(PurchaseStatus.BOUGHT.name()))) {
      throw new IllegalPurchaseStatusException("Illegal purchase status!");
    }
    return PurchaseStatus.valueOf(statusToCheck);
  }

  @Override
  public Set<Purchase> getPurchases(Long userId, String status) throws IllegalPurchaseStatusException {
    PurchaseStatus purchaseStatus = this.getPurchaseStatus(status);
    return purchaseRepository.findPurchaseByUserIdAndStatusOrderByProductId(userId, purchaseStatus);
  }

  public void editPurchases(Long userId, EditPurchaseDTO editPurchase) throws IllegalPurchaseStatusException, PurchaseNotFoundException {
    PurchaseStatus status = this.getPurchaseStatus(editPurchase.getStatus());
    List<Purchase> updatedPurchases = new ArrayList<>();
    for (int i = 0; i < editPurchase.getPurchaseIds().size(); i++) {
      Purchase purchase = purchaseRepository
              .findPurchaseByIdAndUserId(editPurchase.getPurchaseIds().get(i), userId)
              .orElseThrow(() -> new PurchaseNotFoundException("Purchase not found!"));
      purchase.setStatus(status);
      updatedPurchases.add(purchase);
    }

    purchaseRepository.saveAll(updatedPurchases);
  }

  @Override
  public void saveAll(List<Purchase> purchases) {
    purchaseRepository.saveAll(purchases);
  }

  @Override
  public void createPurchase(User user, NewPurchase newPurchase) throws ProductNotFoundException {
    Product product = this.productService.findProductById(newPurchase.getProductID());
    purchaseRepository.saveAll(getMultiplePurchase(user, product, newPurchase.getAmount()));
  }

  public List<Purchase> getMultiplePurchase(User user, Product product, long amount) {
    List<Purchase> purchases = new ArrayList<>();

    for (int i = 0; i < amount; i++) {
      Purchase purchase = new Purchase();
      purchase.setUser(user);
      purchase.setProduct(product);
      purchase.setStatus(PurchaseStatus.PENDING);
      purchase.setOrderDate(new Date());
      purchases.add(purchase);
    }

    return purchases;
  }
}
