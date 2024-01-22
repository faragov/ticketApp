package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    Optional<Product> findById(long productID);

}
