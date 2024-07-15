package com.nipuna.cms.controller;

import com.nipuna.cms.dto.CardDetailDto;
import com.nipuna.cms.dto.CustomRegResponseDto;
import com.nipuna.cms.dto.CustomerRegDto;
import com.nipuna.cms.exception.*;
import com.nipuna.cms.service.CustomerSerRepo;
import com.sun.net.httpserver.Authenticator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cms")
public class CustomerController {

    private final CustomerSerRepo service;

    @PostMapping("/register")
    public ResponseEntity<CustomRegResponseDto> registerUser(@RequestBody @Valid CustomerRegDto customerRegDto) throws BalanceNotEnoughException, Exception, ExistCustomerException {
        CustomRegResponseDto response=CustomRegResponseDto.builder()
                .status("Success")
                .message("Successfully register the user")
                .object(service.registerCustomer(customerRegDto))
                .isCardRequired(customerRegDto.isCardRequired())
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/card-activate")
    public ResponseEntity<CustomRegResponseDto> activateCard(@RequestBody @Valid CardDetailDto cardDetailDto) throws CustomerNotRegisteredException, InvalidCardTypeException, AlreadyHaveCardException {
        CustomRegResponseDto response=CustomRegResponseDto.builder()
                .status("Success")
                .message("Successfully processed")
                .object(service.createCard(cardDetailDto))
                .build();

        return ResponseEntity.ok(response);
    }
}
