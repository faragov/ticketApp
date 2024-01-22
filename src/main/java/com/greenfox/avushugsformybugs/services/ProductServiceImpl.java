package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.GetProductDTO;
import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

  public List<Product> getAllProducts(){
    return productRepository.findAll();
  }

  public GetProductListDTO listAllProducts(){
    List<Product> productList = getAllProducts();
    List<GetProductDTO> productDTOList = new ArrayList<>();
    for(int i=0;i<productList.size();i++){
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
