package com.easyyu.api.buildings.food;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "waterrefill")
public class WaterRefill implements Serializable {
    // Water Bottle Refill Stations - https://foodservices.info.yorku.ca/water-bottle-free-campus/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String campus;   // Keele
    private String building; // Central Square
    private String location; // Outside Central Square Cafeteria

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
