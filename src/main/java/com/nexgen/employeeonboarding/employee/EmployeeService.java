package com.nexgen.employeeonboarding.employee;

import com.nexgen.employeeonboarding.common.mapper.TypeMapper;
import com.nexgen.employeeonboarding.model.Employee;
import com.nexgen.employeeonboarding.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TypeMapper typeMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, TypeMapper typeMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeRepository = employeeRepository;
        this.typeMapper = typeMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = typeMapper.toEmployee(employeeDTO);
        newEmployee.setPassword(this.bCryptPasswordEncoder.encode(employeeDTO.getPassword()));
        newEmployee.setUserName(employeeDTO.getEmailAddress());
        HashSet<Role> roles = new HashSet<>();
        newEmployee.setRoles(roles);
        return typeMapper.toEmployeeDTO(employeeRepository.save(newEmployee));
    }

    public EmployeeDTO findEmployeeByID(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new NoSuchElementException("Employee not found"));
        return typeMapper.toEmployeeDTO(employee);
    }

    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return typeMapper.toEmployeeDTOs(employees);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new NoSuchElementException("Employee not found"));
        Employee updatedEmployee = typeMapper.toEmployee(employeeDTO);
        return typeMapper.toEmployeeDTO(employeeRepository.save(updatedEmployee));
    }

    public EmployeeDTO authenticate(LoginDTO loginDTO) {
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeRepository.findByUserName(loginDTO.getUserName()));
        return optionalEmployee
                .filter(employee -> bCryptPasswordEncoder.matches(loginDTO.getPassword(), employee.getPassword()))
                .map(typeMapper::toEmployeeDTO)
                .orElse(null);
    }

    public Optional<Employee> findByUserName(String userName){
        return Optional.ofNullable(employeeRepository.findByUserName(userName));
    }

}
