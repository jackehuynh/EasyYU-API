package com.easyyu.api.course.offerings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder({ "term", "section", "course_info" })
public class CourseOfferingInfo implements Serializable {

    private String term;
    private String section;

    @JsonProperty("course_info")
    private List<CourseInfo> courseInfo;

    public void setCourseInfo(List<CourseInfo> courseInfo) {
        this.courseInfo = courseInfo;
    }

    public List<CourseInfo> getCourseInfo() {
        return courseInfo;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTerm() {
        return term;
    }

    public String getSection() {
        return section;
    }

}
