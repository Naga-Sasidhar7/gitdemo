package com.core.banking.accounts.Service;

import com.core.banking.accounts.dto.SigninDto;
import com.core.banking.accounts.dto.SignupDto;
import com.core.banking.accounts.entity.AccountsEntity;
import com.core.banking.accounts.entity.BalanceEntity;
import com.core.banking.accounts.repository.AccountsRepository;
import com.core.banking.accounts.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private BalanceRepository balanceRepository;
    public long createAccountService(SignupDto signupDto){
System.out.println("in service");
        return isValidAccount(signupDto);
    }
    public long isValidAccount(SignupDto signupDto){
        Optional<AccountsEntity> fetchedRec=
        accountsRepository.findByPanNumber(signupDto.getPanNumber());
        if(fetchedRec.isEmpty()){
            AccountsEntity accountsEntity = new AccountsEntity();
           // accountsEntity.setAccountId("25367");
            accountsEntity.setAccountType(signupDto.getAccountType());
            //accountsEntity.setDob(signupDto.getDob());
            accountsEntity.setAddress(signupDto.getAddress());
            accountsEntity.setCustomerName(signupDto.getCustomerName());
            accountsEntity.setPassword(signupDto.getPassword());
            accountsEntity.setEmailId(signupDto.getEmailId());
            accountsEntity.setPanNumber(signupDto.getPanNumber());
            accountsEntity.setPhoneNumber(signupDto.getPhoneNumber());
            accountsRepository.save(accountsEntity);
            createBalance(accountsEntity);
           return accountsEntity.getAccountId();
        }
        else{
return fetchedRec.get().getAccountId();
        }
    }

    public String signinAccountService( SigninDto signinDto) {
        return isExistingAccount(signinDto);

    }
    public String isExistingAccount(SigninDto signinDto){
        Optional<AccountsEntity> fetchedRec=
                accountsRepository.findByCustomerNameAndPassword(signinDto.getCustomerName(),signinDto.getPassword());
        if(fetchedRec.isEmpty()){
            System.out.println("no Existing Account");
            return "no existing account";
        }
        else{
            return String.valueOf(fetchedRec.get().getAccountId());


        }
    }

    public void createBalance(AccountsEntity accountsEntity){
        BalanceEntity balanceEntity = new BalanceEntity();
        balanceEntity.setMinBal(1500.00);
        balanceEntity.setAmount(1500.00);
        balanceEntity.setCurrency("INR");
        balanceEntity.setMaxBal(100000.00);
        balanceEntity.setAccountId(String.valueOf(accountsEntity.getAccountId()));



        balanceRepository.save(balanceEntity);
    }
}
