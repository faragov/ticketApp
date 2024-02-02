package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditProductDTO;
import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;

import java.util.List;

public interface ProductService {
  Product convertDtoToProduct(NewProductDTO newProductDTO);

  void deleteProduct(Long id) throws ProductNotFoundException;

  void editProduct(Long id, EditProductDTO editProductDTO) throws ProductNotFoundException;

  void saveNewProduct(Product newProduct);

  List<Product> getAllProducts();

  GetProductListDTO listAllProducts();

  Product findProductById(long productID) throws ProductNotFoundException;
}

