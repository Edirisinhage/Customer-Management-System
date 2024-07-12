package com.nipuna.cms.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomRegResponseDto {
    private String status;
    private String message;
    private Object object;
    private Boolean isCardRequired;

}
