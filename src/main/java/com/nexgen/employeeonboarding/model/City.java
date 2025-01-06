package com.nexgen.employeeonboarding.model;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class City extends AuditedEntity{

    @Column
    private String name;

    @Column
    private String code;

    @ManyToOne
    private State state;
}
