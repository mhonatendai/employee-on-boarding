package com.tenstech.employeeonboarding.model;

import com.tenstech.employeeonboarding.common.util.Status;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String code;

    @ManyToOne
    private Department department;
}
