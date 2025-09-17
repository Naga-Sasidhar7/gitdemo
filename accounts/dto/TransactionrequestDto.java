package com.core.banking.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TransactionrequestDto {

    @NotBlank(message = "Credit account ID is required")
    private String creditAccountId;

    @NotBlank(message = "Debit account ID is required")
    private String debitAccountId;

    @NotNull(message = "Transaction amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
    private Double transactionAmount;

//    @NotBlank(message = "Currency is required")
//    @Size(min = 3, max = 3, message = "Currency must be 3 characters")
//    private String currency;
}
