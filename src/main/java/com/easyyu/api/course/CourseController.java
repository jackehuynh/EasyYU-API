package com.easyyu.api.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    /*
    TODO: Implement UPDATE, POST, PUT, DELETE mappings
     */

    @Autowired
    private CourseService courseService;

    @GetMapping("/subject/{subject}")
    public List<Course> getCoursesBySubject(
            @PathVariable String subject,
            @RequestParam(value = "course_number", required = false) String courseNumber) {
        return courseService.findCourseBySubjectAndOrCourseNumber(subject, courseNumber);
    }

    @GetMapping("/faculty/{faculty}")
    public List<Course> getCoursesByFaculty(@PathVariable String faculty) {
        return courseService.findCourseByFaculty(faculty);
    }

    @GetMapping
    public List<Course> getCoursesByQuery(
            @RequestParam(required = false) String subject,
            @RequestParam(value = "course_number", required = false) String courseNumber,
            @RequestParam(required = false) String faculty) {
        return courseService.findCourseByQuery(subject, courseNumber, faculty);
    }

}
