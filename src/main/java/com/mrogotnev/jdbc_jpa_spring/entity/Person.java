package com.mrogotnev.jdbc_jpa_spring.entity;

import lombok.Data;

@Data
public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
