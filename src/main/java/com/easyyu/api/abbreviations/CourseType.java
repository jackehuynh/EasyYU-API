package com.easyyu.api.abbreviations;

import java.io.Serializable;

// TODO: make it an entity
public class CourseType implements Serializable {

    private String abbreviation; // ex: DISS
    private String type; // ex: Dissertation

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
