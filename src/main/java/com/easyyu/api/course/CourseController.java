package com.easyyu.api.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/courses")
public class CourseController {
    /*
    TODO: Implement UPDATE, POST, PUT, DELETE mappings
    TODO: Make a section for building abbreviations and link it to course locations?
    TODO: split getCoursesByQuery endpoint into separate methods via this example
        - @RequestMapping(method = RequestMethod.GET, params = {"id", "query"})
        - @RequestMapping(method = RequestMethod.GET, params = {"id"})
     */

    @Autowired
    private CourseService courseService;

    @GetMapping("/subject")
    public List<Course> getCoursesBySubject(
            @RequestParam(value = "sj", required = true) String subject,
            @RequestParam(value = "cnum", required = false) String courseNumber) {
        return courseService.findCourseBySubjectAndOrCourseNumber(subject, courseNumber);
    }

    @GetMapping("/faculty")
    public List<Course> getCoursesByFaculty(@RequestParam(value = "fa", required = true) String faculty) {
        return courseService.findCourseByFaculty(faculty);
    }

    @GetMapping("")
    public List<Course> getCoursesByQuery(
            @RequestParam(value = "sj", required = false) String subject,
            @RequestParam(value = "cnum", required = false) String courseNumber,
            @RequestParam(value = "fa", required = false) String faculty) {
        return courseService.findCourseByQuery(subject, courseNumber, faculty);
    }

    // TODO: have a separate entity for instructors to allow for easier querying
    // TODO: change mapping to another URI, maybe combine with getCoursesByQuery
    @GetMapping("/instructor")
    public List<String> getCoursesByInstructor(
            @RequestParam(value="q", required = true) String inst) {
        return courseService.findByInstructor(inst);
    }
}
