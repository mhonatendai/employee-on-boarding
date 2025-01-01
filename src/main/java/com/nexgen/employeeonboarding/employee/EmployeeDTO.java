package com.nexgen.employeeonboarding.employee;


import com.nexgen.employeeonboarding.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private String password;

    private Set<Role> roles;

    private String middleNames;
}
