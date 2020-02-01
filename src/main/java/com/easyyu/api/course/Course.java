package com.easyyu.api.course;

import com.easyyu.api.course.offerings.CourseOfferingInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "courses")
@JsonPropertyOrder(
        { "faculty", "subject", "course_number", "name", "description", "credit",
        "instruction_language", "offerings", "url"})
public class Course implements Serializable {

    private String faculty;
    private String subject;
    private String name;
    private String description;
    private String credit;

    @Column(name = "course_number")
    @JsonProperty(value = "course_number")
    private String courseNumber;

    @Column(name = "loi")
    private String instruction_language;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "offerings")
    @Basic(fetch = FetchType.LAZY)
    private List<CourseOfferingInfo> offerings;

    @Id
    @Column(name = "url")
    private String course_url;

    public void setOfferings(List<CourseOfferingInfo> offerings) {
        this.offerings = offerings;
    }

    public List<CourseOfferingInfo> getOfferings() {
        return offerings;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setcourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setinstruction_language(String instruction_language) {
        this.instruction_language = instruction_language;
    }

    public void setCourse_url(String url) {
        this.course_url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getCredit() {
        return credit;
    }

    public String getCourse_url() {
        return course_url;
    }

    public String getinstruction_language() {
        return instruction_language;
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

    public String getcourseNumber() {
        return courseNumber;
    }

}
