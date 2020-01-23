package com.easyyu.api.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    boolean existsCourseByFacultyAndSubjectAndNameAndCourse_numberAndCredit(String faculty,
                                                                            String subject,
                                                                            String courseName,
                                                                            String courseNumber,
                                                                            String credit);

}
