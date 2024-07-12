package com.nipuna.cms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.NestingKind;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(unique = true)
    private String customer_id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private LocalDate date_of_birth;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int contact_no;

    @Column(nullable = false)
    private CustomerType customer_type;

    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @OneToOne
    @JoinColumn(name = "card_no")
    private CreditCard creditCard;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

}
