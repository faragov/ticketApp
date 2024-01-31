package com.greenfox.avushugsformybugs.services;


import com.greenfox.avushugsformybugs.dtos.EditPurchaseDTO;
import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import java.util.List;
import java.util.Set;


public interface PurchaseService {

    Set<Purchase> findPurchaseByUserIdAndStatus(Long userId, PurchaseStatus status);

    void saveAll(List<Purchase> purchases);

    void createPurchase(User user, NewPurchase newPurchase) throws ProductNotFoundException;

    void checkStatus(PurchaseStatus status);

  List<PurchaseDto> getPurchaseDtos(Long userId, PurchaseStatus status);

  void editPurchases(Long userId, EditPurchaseDTO editPurchase);

}
