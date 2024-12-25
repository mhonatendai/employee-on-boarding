package com.tenstech.employeeonboarding.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Position extends AuditedEntity{

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;
}
