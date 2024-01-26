package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.ErrorMessage;
import com.greenfox.avushugsformybugs.dtos.SuccessMessage;
import com.greenfox.avushugsformybugs.dtos.auth.AuthenticationRequest;
import com.greenfox.avushugsformybugs.dtos.auth.AuthenticationResponse;
import com.greenfox.avushugsformybugs.services.AuthenticationService;
import com.greenfox.avushugsformybugs.dtos.auth.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationService service;

  @Autowired
  public AuthenticationController(AuthenticationService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity register(
          @Valid @RequestBody RegisterRequest request
  ) {
    if (service.checkIfEmailIsNotTaken(request)) {
      return ResponseEntity.ok(service.register(request));
    }else {
      return ResponseEntity.badRequest().body(new ErrorMessage("Email is taken"));
    }
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
}
