package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.models.entities.Purchase;

import java.util.List;

public interface PurchaseService {
    void saveAll(List<Purchase> purchases);




    List<Purchase> createPurchase(Long userId, Long numberOfNewPurchase);
}
