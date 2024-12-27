package com.tenstech.employeeonboarding.common.mapper;

import com.tenstech.employeeonboarding.costcenter.CostCenterDTO;
import com.tenstech.employeeonboarding.employee.EmployeeDTO;
import com.tenstech.employeeonboarding.model.CostCenter;
import com.tenstech.employeeonboarding.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    Employee toEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO toEmployeeDTO(Employee employee);

    List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees);

    CostCenter toCostCenter(CostCenterDTO costCenterDTO);

    CostCenterDTO toCostCenterDTO(CostCenter costCenter);

    List<CostCenterDTO> toCostCenterDTOs(List<CostCenter> costCenters);

}