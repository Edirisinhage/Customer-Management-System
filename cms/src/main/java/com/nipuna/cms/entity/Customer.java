package com.nipuna.cms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
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
