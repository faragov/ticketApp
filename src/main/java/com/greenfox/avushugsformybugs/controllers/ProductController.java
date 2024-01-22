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
    GetProductListDTO productListDTO = productService.listAllProducts();
    return ResponseEntity.status(200).body(productListDTO);
  }
}
