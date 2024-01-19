package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.PurchaseDto;
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
    public Set<Purchase> findPurchaseByUserIdAndStatus(Long userId, PurchaseStatus status) {
        return purchaseRepository.findPurchaseByUserIdAndStatus(userId, status);
    }

    @Override
    public List<PurchaseDto> getPurchaseDtos(Long userId, PurchaseStatus status) {
        Set<Purchase> purchaseList = findPurchaseByUserIdAndStatus(userId, status);
        Purchase purchase = new Purchase();
        List<PurchaseDto> dtoList = new ArrayList<>();
        for (int i = 0; i < purchaseList.size(); i++) {
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
}
