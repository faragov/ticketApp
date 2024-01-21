package com.greenfox.avushugsformybugs.models.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String name;

  private int price;

  private int duration;

  private String description;

  private String type;

  @OneToMany(
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL
  )
  @JoinColumn(name = "product_id")
  private Set<Purchase> purchases;

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setType(String type) {
    this.type = type;
  }
}
