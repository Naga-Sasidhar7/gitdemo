package com.core.banking.accounts.controller;

import com.core.banking.accounts.Service.AccountsService;
import com.core.banking.accounts.dto.SigninDto;
import com.core.banking.accounts.dto.SignupDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AccountsController {
    @Autowired
    private AccountsService accountsService;

    @Valid
    @PostMapping("/create-account")
    public long createAccount(@Valid @RequestBody SignupDto signupDto){
    System.out.println("create account request invoked..");
        return accountsService.createAccountService(signupDto);
    }

    @PostMapping("signin-account")
    public String signinAccount(@Valid @RequestBody SigninDto signinDto){
        System.out.println("signing into account");
        return accountsService.signinAccountService(signinDto);

    }



}
