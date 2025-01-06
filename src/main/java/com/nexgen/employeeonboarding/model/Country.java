package com.nexgen.employeeonboarding.model;

import jakarta.persistence.Column;

public class Country extends AuditedEntity{

    @Column
    private String name;

    @Column
    private String code;
}
