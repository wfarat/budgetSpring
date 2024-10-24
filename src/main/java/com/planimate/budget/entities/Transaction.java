package com.planimate.budget.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String category;
    private BigDecimal amount;
    private LocalDate date;
    private String description;

    @ManyToOne
    private Account account;

    @ManyToOne
    private User user;

}
