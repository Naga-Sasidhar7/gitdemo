package com.core.banking.accounts.repository;

import com.core.banking.accounts.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Double>{
    Optional<BalanceEntity> findByAmount(Double amount);
    Optional<BalanceEntity> findByAccountId(String accountId);
}
