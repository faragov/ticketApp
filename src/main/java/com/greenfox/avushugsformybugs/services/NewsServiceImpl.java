package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.NewNewsDTO;
import com.greenfox.avushugsformybugs.models.entities.News;
import com.greenfox.avushugsformybugs.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NewsServiceImpl implements NewsService {

  private final NewsRepository newsRepository;

  @Autowired
  public NewsServiceImpl(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  @Override
  public News convertDtoToNews(NewNewsDTO newNewsDTO) {

    News news = new News();
    news.setAuthor(newNewsDTO.getAuthor());
    news.setContent(newNewsDTO.getContent());
    news.setTitle(newNewsDTO.getTitle());
    news.setNumberOfClicks(0L);
    news.setCreatedDate(new Date());

    return news;
  }

  @Override
  public void saveNewNews(News news) {

    newsRepository.save(news);
  }
}
