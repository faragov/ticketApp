package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void convertDtoToProduct(NewProductDTO newProductDTO) {

    Product product = new Product();
    product.setName(newProductDTO.getName());
    product.setDuration(newProductDTO.getDuration());
    product.setType(newProductDTO.getType());
    product.setPrice(newProductDTO.getPrice());
    product.setDescription(newProductDTO.getDescription());

    productRepository.save(product);
  }
}
