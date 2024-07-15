package com.nipuna.cms.service;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.nipuna.cms.dto.CardDetailDto;
import com.nipuna.cms.dto.CreateAccountDto;
import com.nipuna.cms.dto.CustomerRegDto;
import com.nipuna.cms.entity.Account;
import com.nipuna.cms.entity.CreditCard;
import com.nipuna.cms.entity.Customer;
import com.nipuna.cms.exception.*;
import com.nipuna.cms.mapper.RegMapper;
import com.nipuna.cms.repository.AccountRepository;
import com.nipuna.cms.repository.CreditCardRepository;
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
import java.util.Optional;

@Data
@Service
public class CustomerService implements CustomerSerRepo{

    private final RegMapper mapper;

    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    private final CreditCardRepository creditCardRepository;
    @Override
    @Transactional
    public Customer registerCustomer(CustomerRegDto customerRegDto) throws BalanceNotEnoughException, ExistCustomerException, InvalidTypeException {
        if(!customerRepository.existsById(customerRegDto.getCustomer_id())){
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

    @Override
    public String createCard(CardDetailDto cardDetailDto) throws InvalidCardTypeException, CustomerNotRegisteredException, AlreadyHaveCardException {
        if(customerRepository.existsById(cardDetailDto.getCustomer_id())){
            if(!creditCardRepository.findByCustomer(customerRepository.findById(cardDetailDto.getCustomer_id()).get()).isPresent()){
                Customer customer=customerRepository.findById(cardDetailDto.getCustomer_id()).get();
                CreditCard creditCard=creditCardRepository.save(mapper.cardReqDtoToCard(cardDetailDto,customer));
                return "Successfully activated the credi card";
            }else{
                throw new AlreadyHaveCardException("Already you have a activated credit card.Cannot activate another");
            }

        }
        throw new CustomerNotRegisteredException("You are not registered");
    }

    @Override
    public String createAccount(CreateAccountDto createAccountDto) throws CustomerNotRegisteredException, InvalidTypeException {
       if(customerRepository.existsById(createAccountDto.getCustomer_id())){
           Customer customer=customerRepository.findById(createAccountDto.getCustomer_id()).get();
           accountRepository.save(mapper.createAccountDtoToAccount(createAccountDto,customer));
          return "You have successfully created an account";
       }else{
           throw new CustomerNotRegisteredException("You have not Registered still");
       }
    }
}
