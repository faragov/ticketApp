package com.greenfox.avushugsformybugs.dtos;

import jakarta.validation.constraints.NotEmpty;

public class UserNewsDTO {

  @NotEmpty(message = "Title can not be empty")
  private String title;
  @NotEmpty(message = "Content can not be empty")
  private String content;

  public UserNewsDTO(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

}
