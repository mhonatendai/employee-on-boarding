package com.tenstech.employeeonboarding.model;

import com.tenstech.employeeonboarding.common.util.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
}
