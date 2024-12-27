package com.tenstech.employeeonboarding.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Employee extends AuditedEntity{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String emailAddress;

    @Column
    private String phoneNumber;

    @Column
    private String password;

    @Column
    private String role;

    @ManyToOne
    private Department department;

    @ManyToOne
    private CostCenter costCenter;

    @ManyToOne
    private Position position;
}
