package com.core.banking.accounts.Service;

import com.core.banking.accounts.dto.TransactionDto;
import com.core.banking.accounts.entity.AccountsEntity;
import com.core.banking.accounts.entity.BalanceEntity;
import com.core.banking.accounts.entity.TransactionEntity;
import com.core.banking.accounts.repository.AccountsRepository;
import com.core.banking.accounts.repository.BalanceRepository;
import com.core.banking.accounts.repository.TransactionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private BalanceRepository balanceRepository;


    public String DebitService(TransactionDto transactionDto){
        Optional<AccountsEntity> fetchRec = accountsRepository.findByAccountId(Long.parseLong(transactionDto.getAccountId()));

        if(fetchRec.isEmpty()) {
            return "Invalid AccountId";
        }
        Optional<BalanceEntity> fetch;
        fetch = balanceRepository.findByAccountId(transactionDto.getAccountId());

        if(fetch.get().getAmount() >= transactionDto.getAmount()){

            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setAmount(transactionDto.getAmount());
            transactionEntity.setTransactionDate(LocalDate.now().toString());
            transactionEntity.setIndicator("Debit");
            transactionRepository.save(transactionEntity);

        }

        fetch.get().setAmount(((fetch.get().getAmount()) - (transactionDto.getAmount())));
        balanceRepository.save(fetch.get());

        return "Transaction Successful";




    }


    public String CreditService( TransactionDto transactionDto) {
        Optional<AccountsEntity> fetchRec = accountsRepository.findByAccountId(Long.parseLong(transactionDto.getAccountId()));

        if(fetchRec.isEmpty()){
            return " Invalid Account id";
        }
        Optional<BalanceEntity> fetch = balanceRepository.findByAccountId(transactionDto.getAccountId());
        if(fetch.isPresent()){
            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setIndicator("Credit");
            transactionEntity.setAmount(transactionDto.getAmount());
            transactionEntity.setTransactionDate(LocalDate.now().toString());
            transactionRepository.save(transactionEntity);

        }
        fetch.get().setAmount(((fetch.get().getAmount())+(transactionDto.getAmount())));
        balanceRepository.save(fetch.get());

        return "Transaction successful";


    }
}
