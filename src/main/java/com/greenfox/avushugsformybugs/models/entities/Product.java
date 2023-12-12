package com.greenfox.avushugsformybugs.models.entities;

import jakarta.persistence.*;

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

}
