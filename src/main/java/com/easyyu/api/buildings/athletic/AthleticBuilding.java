package com.easyyu.api.buildings.athletic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "athleticbuilding")
public class AthleticBuilding implements Serializable {

    // Tait & Fitness centre hours - https://yorkulions.ca/sports/2013/1/3/GEN_0103135339.aspx?id=15

    @Id
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "hours")
    @JsonProperty(value = "hours")
    private List<String> hours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHours() {
        return hours;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
    }
}
