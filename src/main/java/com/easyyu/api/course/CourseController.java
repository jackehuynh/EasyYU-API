package com.easyyu.api.course;

import com.easyyu.api.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    private static final String template = "Yes, %s!";

    @RequestMapping(method = GET, value = "/course")
    public Course course(@RequestParam(value="name", defaultValue = "World") String name) {
        return new Course(String.format(template, name));
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
