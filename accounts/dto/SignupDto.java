package com.core.banking.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class SignupDto {
    @NotBlank(message = "This field cannot be blank")
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$")
    String panNumber;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Name should contain only letters and spaces")
    String customerName;

    @NotBlank(message = "phone number cannot be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    String phoneNumber;

    @NotBlank(message = "address cannot be blank")
    @Size(max = 50,message = "Address cannot be exceed 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s,'-]*$")
    String address;
   //  Date dob;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    String emailId;

    @Size(min = 8,max = 20)
    @NotBlank(message = "atleast one letter and one number")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    String password;

    @NotBlank(message = "enter valid account type")
    @Size(max = 30,message = "cannot exceed 30")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    String accountType;

}
