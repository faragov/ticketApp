package com.greenfox.avushugsformybugs.services;

import com.greenfox.avushugsformybugs.config.jwt.JwtService;
import com.greenfox.avushugsformybugs.dtos.auth.AuthenticationRequest;
import com.greenfox.avushugsformybugs.dtos.auth.AuthenticationResponse;
import com.greenfox.avushugsformybugs.dtos.auth.RegisterRequest;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public AuthenticationResponse register(RegisterRequest request) {
    User user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setAdmin(false);
    repository.save(user);

    String jwtToken = jwtService.generateToken(user);

    AuthenticationResponse currentResponse = new AuthenticationResponse();
    currentResponse.setToken(jwtToken);
    return currentResponse;
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    User user = repository.findByEmail(request.getEmail()).orElseThrow();
    String jwtToken = jwtService.generateToken(user);

    AuthenticationResponse currentResponse = new AuthenticationResponse();
    currentResponse.setToken(jwtToken);
    return currentResponse;
  }
}
