package com.easyyu.api.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/faculty")
    public Faculty insert(Faculty faculty) {
        return facultyRepository.save(faculty);
    }


}
