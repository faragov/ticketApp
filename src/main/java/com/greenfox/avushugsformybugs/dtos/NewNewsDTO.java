package com.greenfox.avushugsformybugs.dtos;

import jakarta.validation.constraints.NotEmpty;

public class NewNewsDTO {

  @NotEmpty(message = "Title can not be empty")
  private String title;
  @NotEmpty(message = "Content can not be empty")
  private String content;
  @NotEmpty(message = "Author can not be empty")
  private String author;

  public NewNewsDTO(String title, String content, String author, Long numberOfClicks) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getAuthor() {
    return author;
  }
}
