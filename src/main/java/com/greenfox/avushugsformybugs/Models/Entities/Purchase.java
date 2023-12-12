package com.greenfox.avushugsformybugs.Models.Entities;

import com.greenfox.avushugsformybugs.Models.Enums.Status;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Status status;

    private Date orderDate;
}
