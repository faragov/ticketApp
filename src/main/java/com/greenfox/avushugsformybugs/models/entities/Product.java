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

  public Long getId(){
    return this.Id;
  }

  public String getName(){
    return this.name;
  }

  public int getPrice(){
    return this.price;
  }

  public int getDuration(){
    return this.duration;
  }

  public String getDescription(){
    return this.description;
  }

  public String getType(){
    return this.type;
  }
}
