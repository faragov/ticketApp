package com.greenfox.avushugsformybugs.dtos;

public class PendingPurchaseDTO {
  private Long id;
  private ProductSlimDTO ticket;

  public PendingPurchaseDTO() {
  }

  public PendingPurchaseDTO(Long id, ProductSlimDTO ticket) {
    this.id = id;
    this.ticket = ticket;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProductSlimDTO getTicket() {
    return ticket;
  }

  public void setTicket(ProductSlimDTO ticket) {
    this.ticket = ticket;
  }
}
