package com.mrogotnev.jdbc_jpa_spring.entity;

import lombok.Data;

import java.util.Map;

@Data
public class ProjectsIDAndEmployeesID {
    private Integer projectId;
    private Integer employeeId;

    public ProjectsIDAndEmployeesID() {
    }

    public ProjectsIDAndEmployeesID(Integer projectId, Integer employeeId) {
        this.projectId = projectId;
        this.employeeId = employeeId;
    }
}
