package com.greenfox.avushugsformybugs.services;


import com.greenfox.avushugsformybugs.dtos.EditPurchaseDTO;
import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import com.greenfox.avushugsformybugs.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.*;


@Service
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseRepository purchaseRepository;
  private final ProductRepository productRepository;

  @Autowired
  public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ProductRepository productRepository) {
    this.purchaseRepository = purchaseRepository;
    this.productRepository = productRepository;
  }


  public Set<Purchase> findPurchaseByUserIdAndStatus(Long userId, PurchaseStatus status) {
    checkStatus(status);
    return purchaseRepository.findPurchaseByUserIdAndStatus(userId, status);
  }

  @Override
  public void checkStatus(PurchaseStatus status) {
    if (!(status == PurchaseStatus.ACTIVE || status == PurchaseStatus.PENDING || status == PurchaseStatus.BOUGHT || status == PurchaseStatus.USED)) {
      throw new IllegalArgumentException("No result.");
    }
  }

  @Override
  public List<PurchaseDto> getPurchaseDtos(Long userId, PurchaseStatus status) {
    Set<Purchase> purchaseSet = findPurchaseByUserIdAndStatus(userId, status);
    List<PurchaseDto> dtoList = new ArrayList<>();
    for (Purchase purchase : purchaseSet) {
      PurchaseDto purchaseDto = new PurchaseDto();
      purchaseDto.setId(purchase.getId());
      purchaseDto.setStatus(purchase.getStatus());
      purchaseDto.setOrderDate(purchase.getOrderDate());
      purchaseDto.setActivateDate(purchase.getActivateDate());
      purchaseDto.setProductName(purchase.getProduct().getName());
      purchaseDto.setProductPrice(purchase.getProduct().getPrice());
      purchaseDto.setProductDuration(purchase.getProduct().getDuration());
      purchaseDto.setProductType(purchase.getProduct().getType());

      dtoList.add(purchaseDto);
    }
    return dtoList;

  }

  public void editPurchases(Long userId, EditPurchaseDTO editPurchase){
    PurchaseStatus status = editPurchase.getStatus();
    Optional<Purchase> oPurchase;
    for(int i=0;i<editPurchase.getPurchaseIds().size();i++){
      oPurchase = purchaseRepository.findPurchaseByIdAndUserId(editPurchase.getPurchaseIds().get(i), userId);
      if(oPurchase.isPresent()){
        Purchase purchase = oPurchase.get();
        purchase.setStatus(status);
        purchaseRepository.save(purchase);
      }
    }
  }
  @Override
  public void saveAll(List<Purchase> purchases) {
    purchaseRepository.saveAll(purchases);
  }

  @Override
  public void createPurchase(User user, NewPurchase newPurchase) throws Exception {
    Optional<Product> oProduct = productRepository.findById(newPurchase.getProductID());

    if (oProduct.isEmpty()) {
      throw new Exception("Wrong Product id");
    }

    Product product = oProduct.get();

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
