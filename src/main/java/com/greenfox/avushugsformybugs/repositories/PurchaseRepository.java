package com.greenfox.avushugsformybugs.repositories;

import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

  Set<Purchase> findPurchaseByUserIdAndStatus(Long userId, PurchaseStatus status);

  @Query(value = "SELECT * FROM purchases WHERE id = :purchaseId AND user_id = :userId", nativeQuery = true)
  Optional<Purchase> findPurchaseByIdAndUserId(@Param("purchaseId") Long id, @Param("userId") Long userId);
}
