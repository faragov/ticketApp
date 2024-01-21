package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.dtos.SuccessMessage;
import com.greenfox.avushugsformybugs.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("admin/product")
  public ResponseEntity postNewProduct(@Valid @RequestBody NewProductDTO newProductDTO) {

    productService.convertDtoToProduct(newProductDTO);

    return new ResponseEntity(new SuccessMessage("Successfully posted"), HttpStatus.CREATED);
  }
}
