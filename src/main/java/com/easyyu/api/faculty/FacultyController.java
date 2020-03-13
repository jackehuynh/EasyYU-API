package com.easyyu.api.faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "${api_url}/faculty")
public class FacultyController {

    /*
    TODO: implement POST, UPDATE, DELETE mapping
     */

    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping("")
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @GetMapping("{code}")
    public Faculty getFaculty(@PathVariable String code) {
        return facultyRepository.findByCodeAllIgnoreCase(code);
    }

}
