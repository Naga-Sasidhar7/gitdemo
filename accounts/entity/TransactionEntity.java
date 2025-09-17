package com.core.banking.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class TransactionEntity {
    @GeneratedValue
    @Id
    private long transactionId;
    private String accountId;
    private Double amount;
    private String currency;
    private String transactionDate;
    private String indicator;
}
