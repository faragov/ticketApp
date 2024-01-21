package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

  @Override
  public void deleteProduct(Long id) {

    Optional<Product> product = productRepository.findById(id);
    if (product.isPresent()) {
      Product foundProduct = product.get();
      productRepository.delete(foundProduct);
    }
  }

  @Override
  public void editProduct(Long id, NewProductDTO newProductDTO) {
    Optional<Product> foundProduct = productRepository.findById(id);
    if (foundProduct.isPresent()) {
      foundProduct.get().setName(newProductDTO.getName());
      foundProduct.get().setDuration(newProductDTO.getDuration());
      foundProduct.get().setType(newProductDTO.getType());
      foundProduct.get().setPrice(newProductDTO.getPrice());
      foundProduct.get().setDescription(newProductDTO.getDescription());

      productRepository.save(foundProduct.get());
    }
  }
}
