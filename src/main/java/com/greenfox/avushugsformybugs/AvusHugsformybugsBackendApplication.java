package com.greenfox.avushugsformybugs;

import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.Role;
import com.greenfox.avushugsformybugs.repositories.UserRepository;
import com.greenfox.avushugsformybugs.services.AdminInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AvusHugsformybugsBackendApplication implements CommandLineRunner {

  private final AdminInit adminInit;

  public AvusHugsformybugsBackendApplication(AdminInit adminInit) {
    this.adminInit = adminInit;
  }

  public static void main(String[] args) {
    SpringApplication.run(AvusHugsformybugsBackendApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    adminInit.initAdmin();
  }
}
