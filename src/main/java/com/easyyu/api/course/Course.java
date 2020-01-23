package com.easyyu.api.course;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    private String faculty;
    private String subject;
    private String courseCode;
    private String name;
    private String description;
    private String credit;
    private String loi;

    private String url;

    public String getDescription() {
        return description;
    }

    public String getCredit() {
        return credit;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSubject() {
        return subject;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
