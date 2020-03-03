package com.easyyu.api.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/subject")
public class SubjectController {

    /*
    TODO: implement UPDATE, POST, DELETE mapping
    TODO: look @RestControllerAdvice and filter for controller
     */

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{subject}")
    public Subject findBySubject(@PathVariable String subject) {
        return subjectRepository.findBySubjectAllIgnoreCase(subject);
    }
}
