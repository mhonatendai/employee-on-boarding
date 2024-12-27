package com.tenstech.employeeonboarding.costcenter;

import com.tenstech.employeeonboarding.common.mapper.TypeMapper;
import com.tenstech.employeeonboarding.model.CostCenter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CostCenterService {

    private final CostCenterRepository costCenterRepository;

    private final TypeMapper typeMapper;

    public CostCenterService(CostCenterRepository costCenterRepository, TypeMapper typeMapper) {
        this.costCenterRepository = costCenterRepository;
        this.typeMapper = typeMapper;
    }

    public CostCenterDTO create(CostCenterDTO costCenterDTO) {
        CostCenter newCostCenter = typeMapper.toCostCenter(costCenterDTO);
        return typeMapper.toCostCenterDTO(costCenterRepository.save(newCostCenter));
    }

    public CostCenterDTO findById(Long id) throws EntityNotFoundException {
        CostCenter costCenter = costCenterRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No entity found with id: " + id));
        return typeMapper.toCostCenterDTO(costCenter);
    }

    public List<CostCenterDTO> findAll() {
        return typeMapper.toCostCenterDTOs(costCenterRepository.findAll());
    }

    public CostCenterDTO update(Long id, CostCenterDTO costCenterDTO) {
        CostCenter costCenter = costCenterRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No entity found with id: " + id));
        return typeMapper.toCostCenterDTO(costCenterRepository.save(costCenter));
    }
}
