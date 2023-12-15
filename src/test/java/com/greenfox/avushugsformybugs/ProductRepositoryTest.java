package com.greenfox.avushugsformybugs;

import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    public void setupTestData(){
        product = new Product();
    }

    @Test
    public void findAllProducts(){

        productRepository.save(product);

        List<Product> productList = productRepository.findAll();

        assertFalse(productList.isEmpty());
    }

    @Test
    public void findProductById(){

        productRepository.save(product);

        Optional<Product> foundProduct = productRepository.findById(Long.parseLong("1"));

        assertTrue(foundProduct.isPresent());
    }
}
