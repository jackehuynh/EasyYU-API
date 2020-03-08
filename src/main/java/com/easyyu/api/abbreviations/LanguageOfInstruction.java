package com.easyyu.api.abbreviations;

import java.io.Serializable;

public class LanguageOfInstruction implements Serializable {

    private String abbreviation; // EN
    private String loi; // language of instruction - English

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLoi() {
        return loi;
    }

    public void setLoi(String loi) {
        this.loi = loi;
    }
}
