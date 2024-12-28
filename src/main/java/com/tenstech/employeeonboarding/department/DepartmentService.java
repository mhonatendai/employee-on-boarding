package com.tenstech.employeeonboarding.department;

import com.tenstech.employeeonboarding.common.mapper.TypeMapper;
import com.tenstech.employeeonboarding.model.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final TypeMapper typeMapper;


    public DepartmentService(DepartmentRepository departmentRepository, TypeMapper typeMapper) {
        this.departmentRepository = departmentRepository;
        this.typeMapper = typeMapper;
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = typeMapper.toDepartment(departmentDTO);
        return typeMapper.toDepartmentDTO(departmentRepository.save(department));
    }
}
