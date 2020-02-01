package com.easyyu.api.course.offerings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder({ "type", "meet_info", "cat", "instructor", "notes" })
public class CourseInfo implements Serializable {

    /*
    TODO: Decide if cat should be renamed for better readability, should it be an array or a single string
     */
    private String type;
    private String[] cat;
    private String[] instructor;
    private String[] notes;

    @JsonProperty("meet_info")
    private List<CourseMeetInfo> courseMeetInfo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CourseMeetInfo> getCourseMeetInfo() {
        return courseMeetInfo;
    }

    public void setCourseMeetInfo(List<CourseMeetInfo> courseMeetInfo) {
        this.courseMeetInfo = courseMeetInfo;
    }

    public String[] getCat() {
        return cat;
    }

    public void setCat(String[] cat) {
        this.cat = cat;
    }

    public String[] getInstructor() {
        return instructor;
    }

    public void setInstructor(String[] instructor) {
        this.instructor = instructor;
    }

    public String[] getNotes() {
        return notes;
    }

    public void setNotes(String[] notes) {
        this.notes = notes;
    }
}
