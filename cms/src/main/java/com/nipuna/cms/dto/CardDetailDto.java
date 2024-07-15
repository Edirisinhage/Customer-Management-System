package com.nipuna.cms.dto;

import com.nipuna.cms.entity.CardType;
import com.nipuna.cms.entity.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDetailDto {

    @NotNull(message = "Customer id is required")
    @Size(max = 10,min = 10,message = "customer id must be 10 digit")
    private String customer_id;
    @NotNull(message = "Card type required")
    private CardType cardType;
    @NotNull(message = "Required")
    private Double balance;
}
