package com.mrogotnev.jdbc_jpa_spring.entity;

import lombok.Data;

@Data
public class Project {
    private int id;
    private String ProjectName;
    private boolean status;
    private int clientId;

    public Project(int id, String ProjectName, boolean status, int clientId) {
        this.id = id;
        this.ProjectName = ProjectName;
        this.status = status;
        this.clientId = clientId;
    }
}
