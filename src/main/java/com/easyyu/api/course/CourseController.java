package com.easyyu.api.course;

import com.easyyu.api.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseService.findAll();
    }


}
