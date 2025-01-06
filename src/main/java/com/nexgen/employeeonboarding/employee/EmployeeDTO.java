package com.nexgen.employeeonboarding.employee;


import com.nexgen.employeeonboarding.common.util.Gender;
import com.nexgen.employeeonboarding.common.util.MaritalStatus;
import com.nexgen.employeeonboarding.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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

    private String middleName;

    private LocalDate dateOfBirth;

    private String idNumber;

    private String idType;

    private String addressOne;

    private String addressTwo;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private String emergencyPerson;

    private String emergencyPersonContact;

    @Override
    public String toString() {
        return  "EmployeeDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
                ", middleNames='" + middleName + '\'' +
                '}';
    }
}
