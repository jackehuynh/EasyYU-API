package com.easyyu.api.faculty;

import com.easyyu.api.utils.HttpServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping(path = "${api_url}/faculty")
public class FacultyController {

    /*
    TODO: implement POST, UPDATE, DELETE mapping
     */

    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping("")
    public List<Faculty> getAllFaculty(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return facultyRepository.findAll();
    }

    @GetMapping("/{code}")
    public Faculty getFaculty(@PathVariable String code) {
        return facultyRepository.findByCodeAllIgnoreCase(code).orElseThrow(InvalidParameterException::new);
    }

}
