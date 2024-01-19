package com.greenfox.avushugsformybugs.dtos;

import com.greenfox.avushugsformybugs.models.entities.Product;

public class GetProductDTO {
  private Long Id;

  private String name;

  private int price;

  private int duration;

  private String description;

  private String type;

  public GetProductDTO(Product product){
    this.Id = product.getId();

    this.name = product.getName();

    this.price = product.getPrice();

    this.duration = product.getDuration();

    this.description = product.getDescription();

    this.type = product.getType();
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
