package com.tenstech.employeeonboarding.costcenter;

import com.tenstech.employeeonboarding.model.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {

    Optional<CostCenter> findByName(String name);
}
