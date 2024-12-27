package com.tenstech.employeeonboarding.costcenter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cost-center")
public class CostCenterController {

    private final CostCenterService costCenterService;

    public CostCenterController(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping
    public List<CostCenterDTO> getAllCenters() {
        return costCenterService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostCenterDTO> getCostCenterById(@PathVariable Long id) {
        CostCenterDTO centerDTO = costCenterService.findById(id);
        return centerDTO != null ? ResponseEntity.ok(centerDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CostCenterDTO> createCostCenter(@RequestBody CostCenterDTO costCenterDTO) {
        CostCenterDTO costCenter = costCenterService.create(costCenterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(costCenter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CostCenterDTO> updateCostCenter(@PathVariable Long id, @RequestBody CostCenterDTO costCenterDTO) {
        CostCenterDTO updateCostCenter = costCenterService.update(id, costCenterDTO);
        return updateCostCenter != null ? ResponseEntity.ok(updateCostCenter) : ResponseEntity.notFound().build();
    }
}
