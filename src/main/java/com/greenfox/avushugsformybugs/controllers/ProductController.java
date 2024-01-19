package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.GetProductDTO;
import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity getProducts(){
    List<Product> productList = productService.getAllProducts();
    List<GetProductDTO> productDTOList = new ArrayList<>();
    for(int i=0;i<productList.size();i++){
      productDTOList.add(new GetProductDTO(productList.get(i)));
    }
    GetProductListDTO productListDTO = new GetProductListDTO(productDTOList);
    return ResponseEntity.status(200).body(productListDTO);
  }
}
