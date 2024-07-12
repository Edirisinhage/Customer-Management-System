package com.nipuna.cms.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ExistCustomerException extends Throwable {

    private final String message;

    public ExistCustomerException(String message) {
        this.message = message;
    }
}
