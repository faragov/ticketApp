package com.greenfox.avushugsformybugs.repositories;

import com.greenfox.avushugsformybugs.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
