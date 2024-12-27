package com.tenstech.employeeonboarding.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CostCenter extends AuditedEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private Boolean active;

    @Column
    private String code;

    @ManyToOne
    private Department department;
}
