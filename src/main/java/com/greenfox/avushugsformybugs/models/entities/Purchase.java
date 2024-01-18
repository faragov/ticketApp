package com.greenfox.avushugsformybugs.models.entities;

import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "purchases")
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Enumerated(EnumType.STRING)
  private PurchaseStatus status;

  private Date orderDate;

  private Date activateDate;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
