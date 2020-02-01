package com.easyyu.api.course.offerings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({ "day", "start_time", "duration", "location" })
public class CourseMeetInfo implements Serializable {

    private String day;
    private String duration;
    private String location;

    @JsonProperty("start_time")
    private String startTime;

    public void setDay(String day) {
        this.day = day;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDay() {
        return day;
    }

    public String getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getLocation() {
        return location;
    }
}
