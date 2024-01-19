package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import com.greenfox.avushugsformybugs.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseRepository purchaseRepository;

  @Autowired
  public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }

  @Override
  public List<Purchase> findPurchaseByUserIdAndStatus(Long userId, PurchaseStatus status) {
    return purchaseRepository.findPurchaseByUserIdAndStatus(userId, status);
  }

  @Override
  public List<PurchaseDto> getPurchaseDtos(Long userId, PurchaseStatus status) {
    List<Purchase> purchaseList = findPurchaseByUserIdAndStatus(userId, status);
    List<Product> productList = findPurchaseByUserIdAndStatus(userId, status);
    List<PurchaseDto> dtoList = new ArrayList<>();
    PurchaseDto purchaseDto = new PurchaseDto();
    for (int i = 0; i < purchaseList.size(); i++) {
      purchaseDto.setId(purchaseList.get(i).getId());
      purchaseDto.setStatus(purchaseList.get(i).getStatus());
      purchaseDto.setOrderDate(purchaseList.get(i).getOrderDate());
      purchaseDto.setActivateDate(purchaseList.get(i).getActivateDate());
      dtoList.add(purchaseDto);
    }
    for (int j = 0; j < productList.size(); j++) {
      purchaseDto.setProductName(productList.get(j).getName());
      purchaseDto.setProductPrice(productList.get(j).getPrice());
      purchaseDto.setProductDuration(productList.get(j).getDuration());
      purchaseDto.setProductType(productList.get(j).getType());
      dtoList.add(purchaseDto);
    }
    return dtoList;
  }
}
