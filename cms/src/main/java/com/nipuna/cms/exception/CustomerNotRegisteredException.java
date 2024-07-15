package com.nipuna.cms.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@RequiredArgsConstructor
public class CustomerNotRegisteredException extends Throwable {

    private final String message;
}
