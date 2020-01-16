package com.easyyu.api.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping("/faculty")
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @GetMapping("/faculty/{code}")
    public Faculty getFaculty(@PathVariable String code) {
        return facultyRepository.findByCode(code);
    }

}
