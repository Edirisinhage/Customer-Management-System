package com.nipuna.cms.exception;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.nipuna.cms.dto.CustomRegResponseDto;
import com.nipuna.cms.dto.ErrorResponseDto;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GloobalExceptionHandler {

    @ExceptionHandler(BalanceNotEnoughException.class)
    public ResponseEntity<CustomRegResponseDto> balanceNotEnoughException(BalanceNotEnoughException balanceNotEnoughException){
         CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Registration Failed")
                .object(balanceNotEnoughException.getMessage())
                .build();

         return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(InvalidTypeIdException.class)
    public ResponseEntity<CustomRegResponseDto> invalidTypeException(InvalidTypeIdException exception){
        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Registration Failed")
                .object(exception.getMessage())
                .build();

        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CustomRegResponseDto> validationException(ValidationException exception){
        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Registration Failed")
                .object(exception.getMessage())
                .build();

        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomRegResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors=exception.getBindingResult().getFieldErrors();

        List<ErrorResponseDto> errors=fieldErrors.stream()
                .map(fieldError ->new ErrorResponseDto(fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Registration Failed")
                .object(errors)
                .build();

        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomRegResponseDto> dataIntegrityViolation(DataIntegrityViolationException exception){


        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Data integrity violation")
                .object(exception.getMessage())
                .build();

        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(ExistCustomerException.class)
    public ResponseEntity<CustomRegResponseDto> existCustomerException(ExistCustomerException exception){


        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Registration Failed")
                .object(exception.getMessage())
                .build();

        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(InvalidCardTypeException.class)
    public ResponseEntity<CustomRegResponseDto> existCustomerException(InvalidCardTypeException exception){


        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Card Activation Failed")
                .object(exception.getMessage())
                .build();

        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(CustomerNotRegisteredException.class)
    public ResponseEntity<CustomRegResponseDto> existCustomerException(CustomerNotRegisteredException exception){


        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Card Activation Failed")
                .object(exception.getMessage())
                .build();

        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(AlreadyHaveCardException.class)
    public ResponseEntity<CustomRegResponseDto> existCustomerException(AlreadyHaveCardException exception){


        CustomRegResponseDto errorResponse=CustomRegResponseDto.builder()
                .status("Failed")
                .message("Card Activation Failed")
                .object(exception.getMessage())
                .build();

        return ResponseEntity.ok(errorResponse);
    }
}
