package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.models.entities.Purchase;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  public List<Product> getAllProducts();

  public GetProductListDTO listAllProducts();

    Optional<Product> findById(long productID);
}
