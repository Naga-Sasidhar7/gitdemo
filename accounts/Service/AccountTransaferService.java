package com.core.banking.accounts.Service;

import com.core.banking.accounts.controller.AccountTransferController;
import com.core.banking.accounts.dto.TransactionDto;
import com.core.banking.accounts.dto.TransactionrequestDto;
import com.core.banking.accounts.entity.AccountsEntity;
import com.core.banking.accounts.entity.TransactionEntity;
import com.core.banking.accounts.repository.AccountsRepository;
import com.core.banking.accounts.repository.BalanceRepository;
import com.core.banking.accounts.repository.TransactionRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountTransaferService {
    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private AccountsRepository accountsrepository;
    @Autowired
    private TransactionRepository transactionRepository;

//    public AccountTransaferService(TransactionService transactionService,AccountsRepository accountsRepository){
//        this.transactionService = transactionService;
//        this.accountsRepository = accountsRepository;
//    }



    public String accounttransaction(@Valid TransactionrequestDto transactionrequestDto) {

        Long creditAccountId = parseAccountId(transactionrequestDto.getCreditAccountId());
        Long debitAccountId = parseAccountId(transactionrequestDto.getDebitAccountId());

        Optional<AccountsEntity> fetchc = accountsrepository.findByAccountId(Long.parseLong(transactionrequestDto.getCreditAccountId()));
        if(fetchc.isEmpty()){
            return "Invalid Credit AccountId";
        }
        Optional<AccountsEntity> fetchd = accountsrepository.findByAccountId(Long.parseLong(transactionrequestDto.getDebitAccountId()));
        if(fetchd.isEmpty()){
            return "Invalid Debit AccountId";
        }

        if(transactionrequestDto.getDebitAccountId().equals(transactionrequestDto.getCreditAccountId())){
            return "Both are same account";
        }

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAmount(transactionrequestDto.getTransactionAmount());
     //   transactionDto.setAccountId(transactionrequestDto.getCreditAccountId());
        transactionDto.setAccountId(transactionrequestDto.getDebitAccountId());
//        transactionDto.setCurrency(transactionrequestDto.getCurrency());

        String Debit = transactionService.DebitService(transactionDto);
        if(!Debit.equals("Transaction Successful")){
            return "Debit failed"+ Debit;
        }
        transactionDto.setAccountId(transactionrequestDto.getCreditAccountId());
        String Credit = transactionService.CreditService(transactionDto);
        if(!Credit.equals("Transaction successful")){
            return "Credit failed"+Credit;

        }



        return "Transaction Successful";


    }

    private Long parseAccountId(@NotBlank(message = "Credit account ID is required") String creditAccountId) {
        return null;
    }
}
