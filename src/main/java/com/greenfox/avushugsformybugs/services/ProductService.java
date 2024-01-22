package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditProductDTO;
import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;

public interface ProductService {
  Product convertDtoToProduct(NewProductDTO newProductDTO);

  void deleteProduct(Long id);

  void editProduct(Long id, EditProductDTO editProductDTO);

  void saveNewProduct(Product newProduct);
}
