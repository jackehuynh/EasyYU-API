package com.easyyu.api.subject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    private String subject;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject1 = (Subject) o;
        return getSubject().equals(subject1.getSubject()) &&
                getName().equals(subject1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getName());
    }

}
