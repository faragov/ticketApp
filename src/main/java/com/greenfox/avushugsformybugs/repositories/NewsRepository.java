package com.greenfox.avushugsformybugs.repositories;

import com.greenfox.avushugsformybugs.models.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
