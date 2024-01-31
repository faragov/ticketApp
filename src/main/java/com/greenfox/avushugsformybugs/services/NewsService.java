package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditNewsDTO;
import com.greenfox.avushugsformybugs.dtos.NewNewsDTO;
import com.greenfox.avushugsformybugs.dtos.TopNewsDTO;
import com.greenfox.avushugsformybugs.models.entities.News;

import java.util.List;

public interface NewsService {
  News convertDtoToNews(NewNewsDTO newNewsDTO);

  void saveNewNews(NewNewsDTO newNewsDTO);

  void deleteNews(Long id);

  void editNews(Long id, EditNewsDTO editNewsDTO);

  List<News> findeTopThree();

  TopNewsDTO convertNewsToDTO(News news);

  List<TopNewsDTO> convertTopThree();
}
