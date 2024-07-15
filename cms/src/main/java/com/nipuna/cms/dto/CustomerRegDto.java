package com.nipuna.cms.dto;

import com.nipuna.cms.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegDto {

    @NotNull(message = "National id is required")
    @Size(max = 10,min = 10,message = "Id must be 10 digit")
    private String customer_id;

    @NotNull(message = "Full name cannot be null")
    private String fullname;

    @NotNull(message = "Date of birth cannot be null")
    private LocalDate date_of_birth;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Not a valid email")
    private String email;

    private int contact_no;

    @NotNull(message = "Customer Type Cannot Be Null")
    private CustomerType customer_type;

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "username cannot be null")
    @Size(message = "minimum size:4 and maximum size:15",max = 15,min = 4)
    private String username;

    @NotNull(message = "Role is required")
    private Role role;

    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull(message = "isCardRequired is required")
    private  boolean isCardRequired;

    private Double balance;

    @NotNull(message = "Account Type cannot be null")
    private AccountType accountType;
}
