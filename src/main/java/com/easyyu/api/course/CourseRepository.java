package com.easyyu.api.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findBySubjectAllIgnoreCase(String subject);
    List<Course> findBySubjectAndCourseNumberAllIgnoreCase(String subject, String courseNumber);
    List<Course> findByFacultyAllIgnoreCase(String faculty);
    List<Course> findByFacultyAndSubjectAndCourseNumberAllIgnoreCase(
            String faculty, String Subject, String courseNumber);
}