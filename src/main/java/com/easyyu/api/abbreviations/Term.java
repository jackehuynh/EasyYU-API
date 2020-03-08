package com.easyyu.api.abbreviations;

import java.io.Serializable;

public class Term implements Serializable {

    private String abbreviation; // F
    private String term; // Fall (September-December)

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
