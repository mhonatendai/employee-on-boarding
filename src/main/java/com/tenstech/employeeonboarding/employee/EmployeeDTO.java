package com.tenstech.employeeonboarding.employee;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private String password;

    private String role;
}
