package com.mrogotnev.jdbc_jpa_spring.dto;

import lombok.Data;

@Data
public class EmplOnAllPrjDto {
    private int emplId;
    private int prjId;
    private String prjName;
    private boolean prjStatus;

    public EmplOnAllPrjDto(int emplId, int prjId, String prjName, boolean prjStatus) {
        this.emplId = emplId;
        this.prjId = prjId;
        this.prjName = prjName;
        this.prjStatus = prjStatus;
    }
}
