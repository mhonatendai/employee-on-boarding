package com.tenstech.employeeonboarding.costcenter;

import com.tenstech.employeeonboarding.model.CostCenter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CostCenterService {

    private final CostCenterRepository repository;

    public CostCenterService(CostCenterRepository repository) {
        this.repository = repository;
    }

    public CostCenter create(CostCenterDTO costCenterDTO) {
        CostCenter costCenter = new CostCenter();
        costCenter.setName(costCenterDTO.getName());
        costCenter.setDescription(costCenterDTO.getDescription());
        return repository.save(costCenter);
    }

    public CostCenter findById(Long id) throws EntityNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No entity found with id: " + id));
    }

    public List<CostCenter> findAll() {
        return repository.findAll();
    }

    public CostCenter update(Long id, CostCenterDTO costCenterDTO) {
        CostCenter costCenter = findById(id);
        costCenter.setName(costCenterDTO.getName());
        costCenter.setDescription(costCenterDTO.getDescription());
        return repository.save(costCenter);
    }
}
