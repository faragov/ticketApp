package com.greenfox.avushugsformybugs.dtos;

import java.util.List;

public class GetProductListDTO {

  private List<GetProductDTO> products;

  public GetProductListDTO(List<GetProductDTO> productList) {
    this.products = productList;
  }

  public List<GetProductDTO> getProducts() {
    return this.products;
  }

  public void setProducts(List<GetProductDTO> products) {
    this.products = products;
  }
}
