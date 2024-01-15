package com.greenfox.avushugsformybugs.models.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String name;

  private String email;

  private String password;

  private boolean isAdmin;

  private boolean isVerified;

  public User() {
  }

  @OneToMany(
          fetch = FetchType.LAZY,
          cascade = CascadeType.ALL
  )
  @JoinColumn(name = "user_id")
  private Set<Purchase> purchases;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public void setVerified(boolean verified) {
    isVerified = verified;
  }

  public void setPurchases(Set<Purchase> purchases) {
    this.purchases = purchases;
  }
}
