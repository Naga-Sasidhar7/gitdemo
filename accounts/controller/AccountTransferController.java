package com.core.banking.accounts.controller;

import com.core.banking.accounts.Service.AccountTransaferService;
import com.core.banking.accounts.dto.TransactionrequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountTransferController {

    @Autowired
    public AccountTransaferService accountTransaferService;

    @PostMapping("/account-transfer")
    public String accounttransaction(@Valid @RequestBody TransactionrequestDto transactionrequestDto){
        System.out.println(" Transaction completed ");
        return accountTransaferService.accounttransaction(transactionrequestDto);
    }



}
