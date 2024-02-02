package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.EditProductDTO;
import com.greenfox.avushugsformybugs.dtos.NewProductDTO;
import com.greenfox.avushugsformybugs.dtos.SuccessMessage;
import com.greenfox.avushugsformybugs.dtos.GetProductListDTO;
import com.greenfox.avushugsformybugs.exceptions.ProductNotFoundException;
import com.greenfox.avushugsformybugs.models.entities.Product;
import com.greenfox.avushugsformybugs.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/admin/product")
  public ResponseEntity postNewProduct(@Valid @RequestBody NewProductDTO newProductDTO) {

    Product newProduct = productService.convertDtoToProduct(newProductDTO);
    productService.saveNewProduct(newProduct);

    return new ResponseEntity(new SuccessMessage("Successfully posted"), HttpStatus.CREATED);
  }

  @DeleteMapping("/admin/product/{id}")
  public ResponseEntity deleteProductById(@PathVariable Long id) throws ProductNotFoundException {

    productService.deleteProduct(id);

    return new ResponseEntity(new SuccessMessage("Successfully deleted"), HttpStatus.OK);
  }

  @PutMapping("/admin/product/{id}")
  public ResponseEntity editProduct(@PathVariable Long id, @Valid @RequestBody EditProductDTO editProductDTO) throws ProductNotFoundException {

    productService.editProduct(id, editProductDTO);

    return new ResponseEntity(new SuccessMessage("Successfully changed"), HttpStatus.CREATED);
  }

  @GetMapping("/products")
  public ResponseEntity getProducts() {
    GetProductListDTO productListDTO = productService.listAllProducts();
    return ResponseEntity.status(200).body(productListDTO);
  }
}
