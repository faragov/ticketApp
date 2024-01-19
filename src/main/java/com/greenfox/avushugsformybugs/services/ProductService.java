package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;

import java.util.List;

public interface ProductService {
  public List<Product> getAllProducts();

  public GetProductListDTO listAllProducts();
}
