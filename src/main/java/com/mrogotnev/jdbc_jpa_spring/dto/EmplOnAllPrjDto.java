package com.mrogotnev.jdbc_jpa_spring.dto;

import lombok.Data;

@Data
public class EmplOnAllPrjDto {
    private int emplId;
    private String emplFirstName;
    private String emplSecondName;
    private String emplJobTitle;
    private int prjId;
    private String prjName;
    private boolean prjStatus;

    public EmplOnAllPrjDto(int emplId, String emplFirstName, String emplSecondName, String emplJobTitle, int prjId, String prjName, boolean prjStatus) {
        this.emplId = emplId;
        this.emplFirstName = emplFirstName;
        this.emplSecondName = emplSecondName;
        this.emplJobTitle = emplJobTitle;
        this.prjId = prjId;
        this.prjName = prjName;
        this.prjStatus = prjStatus;
    }
}
