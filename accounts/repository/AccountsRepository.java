package com.core.banking.accounts.repository;

import com.core.banking.accounts.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<AccountsEntity, String> {
    Optional<AccountsEntity> findByPanNumber(String panNumber);
    Optional<AccountsEntity> findByCustomerNameAndPassword(String customerName,String password);
    Optional<AccountsEntity> findByAccountId(long accountId);
}
