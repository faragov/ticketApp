package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditProductDTO;
import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.dtos.GetProductDTO;
import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product convertDtoToProduct(NewProductDTO newProductDTO) {

    Product product = new Product();
    product.setName(newProductDTO.getName());
    product.setDuration(newProductDTO.getDuration());
    product.setType(newProductDTO.getType());
    product.setPrice(newProductDTO.getPrice());
    product.setDescription(newProductDTO.getDescription());

    return product;
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
  public void editProduct(Long id, EditProductDTO editProductDTO) {
    Optional<Product> foundProduct = productRepository.findById(id);
    if (foundProduct.isPresent()) {
      if (editProductDTO.getName() != null) {
        foundProduct.get().setName(editProductDTO.getName());
      }
      if (editProductDTO.getDuration() != null) {
        foundProduct.get().setDuration(editProductDTO.getDuration());
      }
      if (editProductDTO.getType() != null) {
        foundProduct.get().setType(editProductDTO.getType());
      }
      if (editProductDTO.getPrice() != null) {
        foundProduct.get().setPrice(editProductDTO.getPrice());
      }
      if (editProductDTO.getDescription() != null) {
        foundProduct.get().setDescription(editProductDTO.getDescription());
      }

      productRepository.save(foundProduct.get());
    }
  }

  @Override
  public void saveNewProduct(Product newProduct) {
    productRepository.save(newProduct);
  }
    
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public GetProductListDTO listAllProducts() {
    List<Product> productList = getAllProducts();
    List<GetProductDTO> productDTOList = new ArrayList<>();
    for (int i = 0; i < productList.size(); i++) {
      productDTOList.add(new GetProductDTO(productList.get(i)));
    }
    GetProductListDTO productListDTO = new GetProductListDTO(productDTOList);
    return productListDTO;
  }

  @Override
  public Optional<Product> findById(long productID) {
    return productRepository.findById(productID);
  }
}
