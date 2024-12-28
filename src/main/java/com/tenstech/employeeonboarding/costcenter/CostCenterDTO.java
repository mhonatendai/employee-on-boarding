package com.tenstech.employeeonboarding.costcenter;

import com.tenstech.employeeonboarding.common.util.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CostCenterDTO {

    private Long id;

    private String name;

    private String description;

    private Status status;

    private String code;
}
