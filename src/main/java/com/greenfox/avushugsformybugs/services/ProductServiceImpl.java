package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditProductDTO;
import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.dtos.GetProductDTO;
import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
  public void deleteProduct(Long id) throws ProductNotFoundException {
    Product product = this.findProductById(id);
    productRepository.delete(product);
  }

  @Override
  public void editProduct(Long id, EditProductDTO editProductDTO) throws ProductNotFoundException {
    Product foundProduct = this.findProductById(id);
    if (editProductDTO.getName() != null) {
      foundProduct.setName(editProductDTO.getName());
    }
    if (editProductDTO.getDuration() != null) {
      foundProduct.setDuration(editProductDTO.getDuration());
    }
    if (editProductDTO.getType() != null) {
      foundProduct.setType(editProductDTO.getType());
    }
    if (editProductDTO.getPrice() != null) {
      foundProduct.setPrice(editProductDTO.getPrice());
    }
    if (editProductDTO.getDescription() != null) {
      foundProduct.setDescription(editProductDTO.getDescription());
    }
    productRepository.save(foundProduct);
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

  public Product findProductById(long productID) throws ProductNotFoundException {
    return productRepository.findById(productID).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
  }
}
