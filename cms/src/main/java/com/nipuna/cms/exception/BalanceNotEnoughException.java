package com.nipuna.cms.exception;

import lombok.Data;

@Data
public class BalanceNotEnoughException extends Throwable {

    private final String message;

}
