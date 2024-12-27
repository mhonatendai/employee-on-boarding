package com.tenstech.employeeonboarding.employee;

import com.tenstech.employeeonboarding.common.mapper.TypeMapper;
import com.tenstech.employeeonboarding.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TypeMapper typeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, TypeMapper typeMapper) {
        this.employeeRepository = employeeRepository;
        this.typeMapper = typeMapper;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = typeMapper.toEmployee(employeeDTO);
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
}
