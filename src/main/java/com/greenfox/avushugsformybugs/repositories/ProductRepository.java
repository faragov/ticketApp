package com.greenfox.avushugsformybugs.repositories;

import com.greenfox.avushugsformybugs.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}