package com.nexgen.employeeonboarding.config;

import com.nexgen.employeeonboarding.employee.EmployeeService;
import com.nexgen.employeeonboarding.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private EmployeeService employeeService;
 
    @Override
    public Optional<String> getCurrentAuditor() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Employee> optionalUser = employeeService.findByUserName(currentUsername);
        return optionalUser.isPresent() ? Optional.of(currentUsername) : Optional.of("system");
    }
}