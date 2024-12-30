package com.nexgen.employeeonboarding.department;

import com.nexgen.employeeonboarding.common.util.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

    private Long id;

    private String name;

    private String description;

    private Status status;

    private String code;
}
