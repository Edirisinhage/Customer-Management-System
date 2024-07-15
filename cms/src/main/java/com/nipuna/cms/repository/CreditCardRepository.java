package com.nipuna.cms.repository;

import com.nipuna.cms.entity.CreditCard;
import com.nipuna.cms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {

    Optional<CreditCard> findByCustomer(Customer customer);
}
