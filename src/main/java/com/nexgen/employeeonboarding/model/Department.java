package com.nexgen.employeeonboarding.model;

import com.nexgen.employeeonboarding.common.util.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department extends AuditedEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String code;
}
