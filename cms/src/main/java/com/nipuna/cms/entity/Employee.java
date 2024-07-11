package com.nipuna.cms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employe_id;

    @Column(nullable = false)
    private String fullname;

    private String department;

    private int contact_no;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
