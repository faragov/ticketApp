package com.greenfox.avushugsformybugs;

import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import com.greenfox.avushugsformybugs.repositories.PurchaseRepository;
import com.greenfox.avushugsformybugs.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void productTest(){

        Product product;
        product = new Product();

        productRepository.save(product);

        List<Product> productList = productRepository.findAll();

        Optional<Product> foundProduct = productRepository.findById(Long.parseLong("1"));

        assertFalse(productList.isEmpty());
        assertTrue(foundProduct.isPresent());
    }

    @Test
    public void purchaseTest(){

        Purchase purchase;
        purchase = new Purchase();

        purchaseRepository.save(purchase);

        List<Purchase> purchaseList = purchaseRepository.findAll();

        Optional<Purchase> foundPurchase = purchaseRepository.findById(Long.parseLong("1"));

        assertFalse(purchaseList.isEmpty());
        assertTrue(foundPurchase.isPresent());
    }

    @Test
    public void userTest(){

        User user;
        user = new User();

        userRepository.save(user);

        List<User> userList = userRepository.findAll();

        Optional<User> foundUser = userRepository.findById(Long.parseLong("1"));

        assertFalse(userList.isEmpty());
        assertTrue(foundUser.isPresent());
    }
}
