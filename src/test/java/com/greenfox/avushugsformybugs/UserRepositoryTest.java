package com.greenfox.avushugsformybugs;

import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  private User user;

  @BeforeEach
  public void setupTestData() {
    user = new User();
  }

  @Test
  public void findAllUsers() {

    userRepository.save(user);

    List<User> userList = userRepository.findAll();

    assertFalse(userList.isEmpty());
  }

  @Test
  public void findUserByIdTest() {

    userRepository.save(user);

    Optional<User> foundUser = userRepository.findById(Long.parseLong("1"));

    assertTrue(foundUser.isPresent());
  }
}
