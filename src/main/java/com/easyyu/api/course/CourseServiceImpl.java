package com.easyyu.api.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void insertCourse(Course c) {
        courseRepository.save(c);
    }

    @Override
    public void updateCourse(Course c) {
        /*
        if (courseRepository.existsCourseByFacultyAndSubjectAndNameAndCourse_numberAndCredit(
                c.getFaculty(),
                c.getSubject(),
                c.getName(),
                c.getCourseCode(),
                c.getCredit())) {
            // TODO: update the row in database
        } else {
            insertCourse(c);
        }
         */
    }

    @Override
    public void executeUpdateCourse(Course c) {

    }

    @Override
    public void deleteCourse(Course c) {

    }
}
