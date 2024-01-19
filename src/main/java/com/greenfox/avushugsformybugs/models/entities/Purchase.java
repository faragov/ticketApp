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

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public PurchaseStatus getStatus() {
    return status;
  }

  public void setStatus(PurchaseStatus status) {
    this.status = status;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public Date getActivateDate() {
    return activateDate;
  }

  public void setActivateDate(Date activateDate) {
    this.activateDate = activateDate;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
