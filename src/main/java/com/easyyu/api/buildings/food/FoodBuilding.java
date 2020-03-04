package com.easyyu.api.buildings.food;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "FoodBuilding")
public class FoodBuilding implements Serializable {

    // Dining Directory information - https://foodservices.info.yorku.ca/dining-directory/

    @Id
    @Column(name = "restaurant")
    private String restaurantName;

    @Column(name = "building")
    private String buildingName;

    @Column(name = "phone")
    private String phoneNumber;

    private String description;
    private List<String> hours;
    private String campus;
    private String email;

    @Column(name = "paymentmethods")
    private List<String> paymentMethods;

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
    }

    public List<String> getHours() {
        return hours;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
