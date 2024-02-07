package com.greenfox.avushugsformybugs.services;


import com.greenfox.avushugsformybugs.dtos.EditPurchaseDTO;
import com.greenfox.avushugsformybugs.dtos.NewPurchase;
import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
import com.greenfox.avushugsformybugs.exceptions.IllegalPurchaseStatusException;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.exceptions.PurchaseNotFoundException;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;

import java.util.List;
import java.util.Set;

public interface PurchaseService {
  void saveAll(List<Purchase> purchases);

  void createPurchase(User user, NewPurchase newPurchase) throws ProductNotFoundException;

  PurchaseStatus getPurchaseStatus(String status) throws IllegalPurchaseStatusException;

  Set<Purchase> getPurchases(Long userId, String status) throws IllegalPurchaseStatusException;

  Set<Purchase> getPurchasesWithStatus(Long userId, String status) throws IllegalPurchaseStatusException;

  void editPurchases(Long userId, EditPurchaseDTO editPurchase) throws IllegalPurchaseStatusException, PurchaseNotFoundException;

}
