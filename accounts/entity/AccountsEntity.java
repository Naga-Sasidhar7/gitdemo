package com.core.banking.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class AccountsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;
    private  String panNumber;
    private   String customerName;
    private  String phoneNumber;
    private String address;
    private Date dob;
    private String emailId;
    private String password;
    private String accountType;


    }

