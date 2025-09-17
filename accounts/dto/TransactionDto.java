package com.core.banking.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TransactionDto {

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9-]+")
    String accountId;


    Double amount;

}
