package com.easyyu.api.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findCourseBySubjectAndOrCourseNumber(String subject, String courseNumber) {
        if (courseNumber == null) {
            return findCourseBySubject(subject);
        }
        return findCourseBySubjectAndCourseNumber(subject, courseNumber);
    }

    public List<Course> findCourseBySubject(String subject) {
        return courseRepository.findBySubjectAllIgnoreCase(subject);
    }

    public List<Course> findCourseBySubjectAndCourseNumber(String subject, String courseNumber) {
        return courseRepository.findBySubjectAndCourseNumberAllIgnoreCase(subject, courseNumber);
    }

    public List<Course> findCourseByFaculty(String faculty) {
        return courseRepository.findByFacultyAllIgnoreCase(faculty);
    }

    public List<Course> findCourseByQuery(String subject, String courseNumber, String faculty) {
        if (faculty != null && subject == null & courseNumber == null) {
            return findCourseByFaculty(faculty);
        }

        if (subject != null && courseNumber == null & faculty == null) {
            return findCourseBySubject(subject);
        }

        if (subject != null && courseNumber != null & faculty == null) {
            return findCourseBySubjectAndCourseNumber(subject, courseNumber);
        }

        return courseRepository.findByFacultyAndSubjectAndCourseNumberAllIgnoreCase(faculty, subject, courseNumber);
    }

    public List<String> findByInstructor(String instructor) {
        // TODO: Incorporate instructor entity to help with returning proper JSON object instead of List<String>
        return courseRepository.findByInstructor(instructor);
    }
}
