package com.greenfox.avushugsformybugs.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class RegisterRequest {

  @NotEmpty(message = "Name can not be empty")
  private String name;
  @NotEmpty(message = "Email can not be empty")
  @Email(message = "Email must be valid")
  private String email;
  @NotEmpty(message = "Password can not be empty")
  private String password;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
