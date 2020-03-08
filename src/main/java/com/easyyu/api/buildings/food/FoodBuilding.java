package com.easyyu.api.buildings.food;

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
@Table(name = "foodbuilding")
public class FoodBuilding implements Serializable {

    // Dining Directory information - https://foodservices.info.yorku.ca/dining-directory/
    // TODO: give Long ID

    @Id
    @Column(name = "restaurant")
    private String restaurantName;

    @Column(name = "building")
    private String buildingName;

    @Column(name = "phone")
    private String phoneNumber;

    private String description;

    @Type(type = "string-array")
    @Column(name = "hours", columnDefinition = "text[]")
    private String[] hours;
    private String campus;
    private String email;

    @Column(name = "paymentmethods")
    private String[] paymentMethods;

    public String[] getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String[] paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }

    public String[] getHours() {
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
