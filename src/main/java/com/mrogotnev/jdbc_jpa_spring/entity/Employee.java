package com.mrogotnev.jdbc_jpa_spring.entity;

import com.mrogotnev.jdbc_jpa_spring.entity.enums.JobTitle;
import lombok.Data;

@Data
public class Employee extends Person {
    private JobTitle jobTitle;

    public Employee(int id, String firstName, String lastName, JobTitle jobTitle) {
        super(id, firstName, lastName);
        this.jobTitle = jobTitle;
    }

    public Employee() {

    }
}
