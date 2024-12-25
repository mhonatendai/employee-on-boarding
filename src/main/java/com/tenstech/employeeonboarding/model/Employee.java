package com.tenstech.employeeonboarding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Employee extends AuditedEntity{

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private String password;

    private String role;

    @ManyToOne
    private Department department;

    @ManyToOne
    private CostCenter costCenter;

    @ManyToOne
    private Position position;
}
