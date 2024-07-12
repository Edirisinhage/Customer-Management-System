package com.nipuna.cms.service;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.nipuna.cms.dto.CustomerRegDto;
import com.nipuna.cms.entity.Account;
import com.nipuna.cms.entity.Customer;
import com.nipuna.cms.exception.BalanceNotEnoughException;
import com.nipuna.cms.exception.ExistCustomerException;
import com.nipuna.cms.mapper.RegMapper;
import com.nipuna.cms.repository.AccountRepository;
import com.nipuna.cms.repository.CustomerRepository;
import com.sun.jdi.InvalidTypeException;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Data
@Service
public class CustomerService implements CustomerSerRepo{

    private final RegMapper mapper;

    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;
    @Override
    @Transactional
    public Customer registerCustomer(CustomerRegDto customerRegDto) throws BalanceNotEnoughException, ExistCustomerException, InvalidTypeException {
        if(customerRepository.existsById(customerRegDto.getCustomer_id())){
            if(customerRegDto.getBalance()>=1500){
                Customer customer =customerRepository.save(mapper.RegToCustomer(customerRegDto));
                if(customer!=null){
                    Account account=accountRepository.save(mapper.RedDtoToAccount(customerRegDto,customer));
                    return customer;
                }

                throw new ExistCustomerException("Customer is already registered");
            }
            throw new BalanceNotEnoughException("Sorry Registration Failed.Minimum balance must be 1500 to start Account");
        }else{
            throw new ExistCustomerException("Checked:Customer is already registered");
        }

    }
}
