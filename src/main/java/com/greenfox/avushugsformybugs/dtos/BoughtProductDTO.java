package com.greenfox.avushugsformybugs.dtos;

public class BoughtProductDTO {
  private Long id;
  private String name;
  private int duration;
  private String description;
  private String type;

  public BoughtProductDTO() {
  }

  public BoughtProductDTO(Long id, String name, int duration, String description, String type) {
    this.id = id;
    this.name = name;
    this.duration = duration;
    this.description = description;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
