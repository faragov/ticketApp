package com.greenfox.avushugsformybugs.repositories;

import com.greenfox.avushugsformybugs.models.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

  @Query(value = "SELECT * FROM news ORDER BY number_of_clicks DESC LIMIT 3", nativeQuery = true)
  List<News> findTopThreeNews();
}
