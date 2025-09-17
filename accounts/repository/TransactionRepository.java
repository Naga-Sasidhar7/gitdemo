package com.core.banking.accounts.repository;

import com.core.banking.accounts.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity,String> {
//    Optional<TransactionEntity> findByAccountId(String accountId);
//
}
