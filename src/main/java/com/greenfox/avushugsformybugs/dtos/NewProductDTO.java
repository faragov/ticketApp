package com.greenfox.avushugsformybugs.dtos;

import jakarta.validation.constraints.NotEmpty;

public class NewProductDTO {

  @NotEmpty
  private String name;

  @NotEmpty
  private int price;

  @NotEmpty
  private int duration;

  @NotEmpty
  private String description;

  @NotEmpty
  private String type;

  public NewProductDTO(String name, int price, int duration, String description, String type) {
    this.name = name;
    this.price = price;
    this.duration = duration;
    this.description = description;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public int getDuration() {
    return duration;
  }

  public String getDescription() {
    return description;
  }

  public String getType() {
    return type;
  }
}
