package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.models.enums.Role;
import com.greenfox.avushugsformybugs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminInit {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Value("${admin.name}")
  private String adminName;

  @Value("${admin.email}")
  private String adminEmail;

  @Value("${admin.password}")
  private String adminPassword;

  @Autowired
  public AdminInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void initAdmin() {
    if (!userRepository.findByEmail(adminEmail).isPresent()) {
      User adminUser = new User();
      adminUser.setName(adminName);
      adminUser.setEmail(adminEmail);
      adminUser.setPassword(passwordEncoder.encode(adminPassword));
      adminUser.setRole(Role.ADMIN);
      userRepository.save(adminUser);
    }
  }
}
