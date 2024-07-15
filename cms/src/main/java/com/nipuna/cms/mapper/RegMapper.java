package com.nipuna.cms.mapper;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.nipuna.cms.dto.CardDetailDto;
import com.nipuna.cms.dto.CustomerRegDto;
import com.nipuna.cms.entity.*;
import com.nipuna.cms.exception.InvalidCardTypeException;
import com.nipuna.cms.repository.CustomerRepository;
import com.sun.jdi.InvalidTypeException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.beans.Encoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

@Service
public class RegMapper {

    @Transactional
    public Customer RegToCustomer(CustomerRegDto customerRegDto) throws DataIntegrityViolationException, InvalidTypeException{
        Customer customer=new Customer();
        customer.setCustomer_id(customerRegDto.getCustomer_id());
        customer.setFullname(customerRegDto.getFullname());
        customer.setUsername(customerRegDto.getUsername());
        customer.setPassword(encoder(customerRegDto.getPassword()));
        if(customerRegDto.getCustomer_type().equals(CustomerType.INDIVIDUAL)){
            customer.setCustomer_type(CustomerType.INDIVIDUAL);
        }else if(customerRegDto.getCustomer_type().equals(CustomerType.BUISNESS)){
            customer.setCustomer_type(CustomerType.BUISNESS);
        }else{
            throw new InvalidTypeException("Invalid Type of Customer");
        }

        if(customerRegDto.getRole().equals(Role.USER)){
            customer.setRole(Role.USER);
        }else{
            throw new InvalidTypeException("Invalid Role");
        }
        customer.setEmail(customerRegDto.getEmail());
        customer.setAddress(customerRegDto.getAddress());
        customer.setDate_of_birth(customerRegDto.getDate_of_birth());
        customer.setContact_no(customerRegDto.getContact_no());
        customer.setRole(Role.USER);

        return customer;
    }

    public static String encoder(String password){
        final byte[] authBytes = password.getBytes(StandardCharsets.UTF_8);
        final String encoded = Base64.getEncoder().encodeToString(authBytes);
        return encoded;
    }

    public Account RedDtoToAccount(CustomerRegDto customerRegDto,Customer customer) throws InvalidTypeException {
       Account account=new Account();
       if(customerRegDto.getAccountType().equals(AccountType.SAVING)){
           account.setAccountType(AccountType.SAVING);
       } else if (customerRegDto.getAccountType().equals(AccountType.CHECKING)) {
           account.setAccountType(AccountType.CHECKING);
       }else{
            throw new InvalidTypeException("Invalid Type of Account type");
        }
       account.setAccount_no((long) (Math.random()*Math.pow(10,10)));
       account.setBalance(customerRegDto.getBalance());
       account.setCustomer(customer);
       account.setCreate_date(LocalDate.now());
       return account;
    }

    public CreditCard cardReqDtoToCard(CardDetailDto cardDetailDto,Customer customer) throws InvalidCardTypeException {
        CreditCard creditCard=new CreditCard();
        creditCard.setCard_no((long) (Math.random()*Math.pow(16,16)));
        if(cardDetailDto.getCardType().equals(CardType.Visa)){
            creditCard.setCardType(CardType.Visa);
        }else if(cardDetailDto.getCardType().equals(CardType.MasterCard)){
            creditCard.setCardType(CardType.MasterCard);
        }else{
            throw new InvalidCardTypeException("You have entered invalid type of card");
        }
        creditCard.setBalance(cardDetailDto.getBalance());
        creditCard.setLimit_amount(200000.00);
        creditCard.setExpire_date(LocalDate.now().plus(10, ChronoUnit.YEARS));
        creditCard.setCustomer(customer);
        return creditCard;
    }
}
