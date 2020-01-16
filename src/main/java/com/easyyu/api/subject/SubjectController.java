package com.easyyu.api.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subject")
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @GetMapping("/subject/{code}")
    public Subject findByCode(@PathVariable String code) {
        return subjectRepository.findByCode(code);
    }

}
