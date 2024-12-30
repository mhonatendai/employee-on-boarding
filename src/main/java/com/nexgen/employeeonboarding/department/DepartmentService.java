package com.nexgen.employeeonboarding.department;

import com.nexgen.employeeonboarding.common.mapper.TypeMapper;
import com.nexgen.employeeonboarding.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("Department with id " + id + " not found"));
        return department!=null?  typeMapper.toDepartmentDTO(departmentRepository.save(typeMapper.toDepartment(departmentDTO))): null;
    }

    public DepartmentDTO findById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Department with id " + id + " not found"));
        return typeMapper.toDepartmentDTO(department);
    }

    public List<DepartmentDTO> findAll() {
        return departmentRepository.findAll().stream().map(typeMapper::toDepartmentDTO).collect(Collectors.toList());
    }
}
