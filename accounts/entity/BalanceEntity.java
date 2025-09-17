package com.core.banking.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BalanceEntity {
    @Id
    private String accountId;
    private String currency;
    private Double amount;
    private Double minBal;
    private Double maxBal;

}
