package com.easyyu.api.abbreviations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "buildingacronym")
public class Building implements Serializable {

    @Id
    private String acronym; // ACE
    private String name;    // Accolaide Building East

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
