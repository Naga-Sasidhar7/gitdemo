package com.core.banking.accounts.controller;

import com.core.banking.accounts.Service.TransactionService;
import com.core.banking.accounts.dto.TransactionDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/debit")
    public String Debit(@Valid @RequestBody TransactionDto transactionDto) {
        return transactionService.DebitService(transactionDto);
    }

    @PostMapping("/credit")  // Add a path value
    public String Credit(@Valid @RequestBody TransactionDto transactionDto) {
        return transactionService.CreditService(transactionDto);


    }
}
