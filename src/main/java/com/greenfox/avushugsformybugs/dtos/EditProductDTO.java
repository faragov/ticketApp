package com.greenfox.avushugsformybugs.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class EditProductDTO {

  private String name;

  @Min(100)
  @Max(50000)
  private Integer price;

  @Min(1)
  @Max(730)
  private Integer duration;

  private String description;

  private String type;

  public EditProductDTO(String name, Integer price, Integer duration, String description, String type) {
    this.name = name;
    this.price = price;
    this.duration = duration;
    this.description = description;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public Integer getPrice() {
    return price;
  }

  public Integer getDuration() {
    return duration;
  }

  public String getDescription() {
    return description;
  }

  public String getType() {
    return type;
  }
}

