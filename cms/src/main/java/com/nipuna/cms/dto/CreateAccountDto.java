package com.nipuna.cms.dto;

import com.nipuna.cms.entity.AccountType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateAccountDto {
    @NotNull(message = "Customer id cannot be null")
    @Size(max = 10,min = 10,message = "Max size 10 and min size 10")
    private String customer_id;

    @NotNull(message = "Deposit_amount is required")
    private Double deposit_amount;

    @NotNull(message = "Account type is required")
    private String accountType;
}
