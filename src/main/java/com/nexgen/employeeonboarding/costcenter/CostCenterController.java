package com.nexgen.employeeonboarding.costcenter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cost-center")
@Slf4j
public class CostCenterController {

    private final CostCenterService costCenterService;

    public CostCenterController(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping
    public ResponseEntity<List<CostCenterDTO>> getAllCenters() {
        List<CostCenterDTO> centers = costCenterService.findAll();
        return ResponseEntity.ok(centers);
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

    @PutMapping
    public ResponseEntity<CostCenterDTO> updateCostCenter(@RequestBody CostCenterDTO costCenterDTO) {
        return costCenterDTO.getId()!=null ? ResponseEntity.ok(costCenterService.update(costCenterDTO.getId(), costCenterDTO))
                : ResponseEntity.badRequest().build();
    }
}
