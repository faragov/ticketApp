package com.greenfox.avushugsformybugs;

import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.repositories.PurchaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PurchaseRepositoryTest {

  @Autowired
  private PurchaseRepository purchaseRepository;

  private Purchase purchase;

  @BeforeEach
  public void setupTestData() {
    purchase = new Purchase();
  }

  @Test
  public void findAllPurchases() {

    purchaseRepository.save(purchase);

    List<Purchase> purchaseList = purchaseRepository.findAll();

    assertFalse(purchaseList.isEmpty());
  }

  @Test
  public void findPurchaseById() {

    purchaseRepository.save(purchase);

    Optional<Purchase> foundPurchase = purchaseRepository.findById(Long.parseLong("1"));

    assertTrue(foundPurchase.isPresent());
  }
}
