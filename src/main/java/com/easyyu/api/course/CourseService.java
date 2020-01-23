package com.easyyu.api.course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    void insertCourse(Course c);
    void updateCourse(Course c);
    void executeUpdateCourse(Course c);
    public void deleteCourse(Course c);
}
