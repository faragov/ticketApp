package com.greenfox.avushugsformybugs.models.entities;

import com.greenfox.avushugsformybugs.models.enums.PurchaseStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private PurchaseStatus status;

    private Date orderDate;
}
