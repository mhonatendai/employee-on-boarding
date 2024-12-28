package com.tenstech.employeeonboarding.model;

import com.tenstech.employeeonboarding.common.util.Status;
import jakarta.persistence.*;
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
    private CostCenter costCenter;

    @ManyToOne
    private Position position;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
}
