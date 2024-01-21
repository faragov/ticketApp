package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.NewProductDTO;

public interface ProductService {
  void convertDtoToProduct(NewProductDTO newProductDTO);
}
