package com.greenfox.avushugsformybugs.Models.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isVerified;
}
