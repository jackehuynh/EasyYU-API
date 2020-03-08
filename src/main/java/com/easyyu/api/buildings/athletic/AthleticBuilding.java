package com.easyyu.api.buildings.athletic;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class)
})
@Entity
@Table(name = "athleticbuilding")
public class AthleticBuilding implements Serializable {

    // Tait & Fitness centre hours - https://yorkulions.ca/sports/2013/1/3/GEN_0103135339.aspx?id=15

    @Id
    private String name;

    @Type(type = "string-array")
    @Column(name = "hours", columnDefinition = "text[]")
    private String[] hours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHours() {
        return hours;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }
}
