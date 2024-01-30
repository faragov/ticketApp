package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.dtos.EditNewsDTO;
import com.greenfox.avushugsformybugs.dtos.NewNewsDTO;
import com.greenfox.avushugsformybugs.models.entities.News;

public interface NewsService {
  News convertDtoToNews(NewNewsDTO newNewsDTO);

  void saveNewNews(News news);

  void deleteNews(Long id);

  void editNews(Long id, EditNewsDTO editNewsDTO);
}
