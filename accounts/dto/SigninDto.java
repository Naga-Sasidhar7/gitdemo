package com.core.banking.accounts.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SigninDto {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Name should contain only letters and spaces")
    String customerName;

    @Size(min = 8,max = 20)
    @NotBlank(message = "atleast one letter and one number")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    String password;

}
