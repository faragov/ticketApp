package com.greenfox.avushugsformybugs.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "news")
public class News {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private String title;
  private String content;
  private String author;
  private Long numberOfClicks;
  private Date createdDate;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Long getNumberOfClicks() {
    return numberOfClicks;
  }

  public void setNumberOfClicks(Long numberOfClicks) {
    this.numberOfClicks = numberOfClicks;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
