package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

  private final NewsService newsService;

  @Autowired
  public NewsController(NewsService newsService) {
    this.newsService = newsService;
  }
}
