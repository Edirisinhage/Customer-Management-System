package com.nipuna.cms.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InvalidCardTypeException extends Throwable {

    private final String message;
}
