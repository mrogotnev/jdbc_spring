package com.mrogotnev.jdbc_jpa_spring.entity;

import lombok.Data;

@Data
public class Client extends Person {
    private String companyName;

    public Client(int id, String firstName, String lastName, String companyName) {
        super(id, firstName, lastName);
        this.companyName = companyName;
    }
}
