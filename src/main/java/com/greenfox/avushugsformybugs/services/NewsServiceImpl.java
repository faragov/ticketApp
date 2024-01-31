package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditNewsDTO;
import com.greenfox.avushugsformybugs.dtos.NewNewsDTO;
import com.greenfox.avushugsformybugs.dtos.TopNewsDTO;
import com.greenfox.avushugsformybugs.models.entities.News;
import com.greenfox.avushugsformybugs.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
  public void saveNewNews(NewNewsDTO newNewsDTO) {

    News news = convertDtoToNews(newNewsDTO);
    newsRepository.save(news);
  }

  @Override
  public void deleteNews(Long id) {

    Optional<News> news = newsRepository.findById(id);
    if (news.isPresent()) {
      News foundNews = news.get();
      newsRepository.delete(foundNews);
    }
  }

  @Override
  public void editNews(Long id, EditNewsDTO editNewsDTO) {

    Optional<News> foundNews = newsRepository.findById(id);
    if (foundNews.isPresent()) {
      News myNews = foundNews.get();
      if (editNewsDTO.getAuthor() != null) {
        myNews.setAuthor(editNewsDTO.getAuthor());
      }
      if (editNewsDTO.getTitle() != null) {
        myNews.setTitle(editNewsDTO.getTitle());
      }
      if (editNewsDTO.getContent() != null) {
        myNews.setContent(editNewsDTO.getContent());
      }
      newsRepository.save(myNews);
    }

  }

  @Override
  public List<News> findeTopThree() {
    List<News> news = newsRepository.findTopThreeNews();
    return news;
  }

  @Override
  public TopNewsDTO convertNewsToDTO(News news) {
    TopNewsDTO myDto = new TopNewsDTO();
    myDto.setAuthor(news.getAuthor());
    myDto.setContent(news.getContent());
    myDto.setTitle(news.getTitle());
    myDto.setCreatedDate(news.getCreatedDate());

    return myDto;
  }

  @Override
  public List<TopNewsDTO> convertTopThree() {

    List<News> topNews = findeTopThree();

    List<TopNewsDTO> topList = new ArrayList<>();
    for (int i = 0; i < topNews.size(); i++) {
      TopNewsDTO top = convertNewsToDTO(topNews.get(i));
      topList.add(top);
    }
    return topList;
  }

  @Override
  public void increaseCount(Long id) {

    Optional<News> foundNews = newsRepository.findById(id);
    if (foundNews.isPresent()) {
      News myNews = foundNews.get();
      myNews.setNumberOfClicks(myNews.getNumberOfClicks() + 1);
    }
  }
}
