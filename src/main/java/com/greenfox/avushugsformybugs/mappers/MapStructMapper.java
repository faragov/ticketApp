package com.greenfox.avushugsformybugs.mappers;

import com.greenfox.avushugsformybugs.dtos.BoughtPurchaseDTO;
import com.greenfox.avushugsformybugs.dtos.PendingPurchaseDTO;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
  @Mapping(target = "ticket", source = "purchase.product")
  PendingPurchaseDTO purchaseToPendingDTO(Purchase purchase);

  Set<PendingPurchaseDTO> purchaseSetToPendingDTOSet(Set<Purchase> purchases);

  Set<BoughtPurchaseDTO> boughtPurchaseSetToDTOSet(Set<Purchase> purchases);
}
