package com.greenfox.avushugsformybugs.models.entities;

import com.greenfox.avushugsformybugs.models.enums.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

  @Enumerated(EnumType.STRING)
  private Role role;

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
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(this.role.name()));
    return authorities;
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

  public void setRole(Role role) {
    this.role = role;
  }

  public void setVerified(boolean verified) {
    isVerified = verified;
  }

  public void setPurchases(Set<Purchase> purchases) {
    this.purchases = purchases;
  }

  public Long getId() {
    return Id;
  }
}
