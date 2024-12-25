package com.tenstech.employeeonboarding.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
}
