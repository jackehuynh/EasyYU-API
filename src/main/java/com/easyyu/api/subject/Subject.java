package com.easyyu.api.subject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {

    @Id
    private String subject;
    private String name;

    public Subject(String subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getName() {
        return this.name;
    }
}
