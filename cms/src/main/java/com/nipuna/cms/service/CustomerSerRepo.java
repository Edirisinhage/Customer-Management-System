package com.nipuna.cms.service;

import com.nipuna.cms.dto.CardDetailDto;
import com.nipuna.cms.dto.CustomerRegDto;
import com.nipuna.cms.entity.Customer;
import com.nipuna.cms.exception.*;

public interface CustomerSerRepo {

    public Object registerCustomer(CustomerRegDto customerRegDto) throws Exception, BalanceNotEnoughException, ExistCustomerException;

    public String createCard(CardDetailDto cardDetailDto) throws InvalidCardTypeException, CustomerNotRegisteredException, AlreadyHaveCardException;
}
