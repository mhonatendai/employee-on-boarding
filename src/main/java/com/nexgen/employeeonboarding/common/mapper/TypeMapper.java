package com.nexgen.employeeonboarding.common.mapper;

import com.nexgen.employeeonboarding.costcenter.CostCenterDTO;
import com.nexgen.employeeonboarding.department.DepartmentDTO;
import com.nexgen.employeeonboarding.employee.EmployeeDTO;
import com.nexgen.employeeonboarding.model.CostCenter;
import com.nexgen.employeeonboarding.model.Department;
import com.nexgen.employeeonboarding.model.Employee;
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

    Department toDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO toDepartmentDTO(Department department);

}