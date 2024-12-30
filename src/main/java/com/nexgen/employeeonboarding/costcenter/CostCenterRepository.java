package com.nexgen.employeeonboarding.costcenter;

import com.nexgen.employeeonboarding.model.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
}
