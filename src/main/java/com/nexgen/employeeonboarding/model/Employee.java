package com.nexgen.employeeonboarding.model;

import com.nexgen.employeeonboarding.common.util.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @Column
    private String userName;
}
