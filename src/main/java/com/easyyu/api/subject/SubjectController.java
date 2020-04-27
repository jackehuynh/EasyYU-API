package com.easyyu.api.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "${api_url}/subject")
public class SubjectController {

    /*
    TODO: implement UPDATE, POST, DELETE mapping
    TODO: look @RestControllerAdvice and filter for controller
     */

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("")
    public List<Subject> getAllSubject(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return subjectRepository.findAll();
    }

    // TODO: need subject service layer to handle this query
    @GetMapping("/{subject}")
    public Subject findBySubject(@PathVariable String subject) {
        return subjectRepository.findBySubjectAllIgnoreCase(subject);
    }
}
