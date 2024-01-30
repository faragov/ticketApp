package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

  private final NewsRepository newsRepository;

  @Autowired
  public NewsServiceImpl(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }
}
