package com.nipuna.cms.service;

import com.nipuna.cms.dto.CustomerRegDto;
import com.nipuna.cms.exception.BalanceNotEnoughException;
import com.nipuna.cms.exception.ExistCustomerException;

public interface CustomerSerRepo {

    public Object registerCustomer(CustomerRegDto customerRegDto) throws Exception, BalanceNotEnoughException, ExistCustomerException;
}
