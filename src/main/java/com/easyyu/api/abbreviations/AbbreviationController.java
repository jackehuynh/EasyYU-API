package com.easyyu.api.abbreviations;

import com.easyyu.api.abbreviations.building.Building;
import com.easyyu.api.abbreviations.building.BuildingRepository;
import com.easyyu.api.abbreviations.coursetype.CourseType;
import com.easyyu.api.abbreviations.coursetype.CourseTypeRepository;
import com.easyyu.api.abbreviations.dotw.DaysOfTheWeek;
import com.easyyu.api.abbreviations.dotw.DaysRepository;
import com.easyyu.api.abbreviations.loi.LanguageOfInstruction;
import com.easyyu.api.abbreviations.loi.LoiRepository;
import com.easyyu.api.abbreviations.term.Term;
import com.easyyu.api.abbreviations.term.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping(path = "${api_url}/abbreviations")
public class AbbreviationController {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private DaysRepository daysRepository;

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Autowired
    private LoiRepository loiRepository;

    @Autowired
    private TermRepository termRepository;

    @GetMapping("/buildings")
    public List<Building> getAllBuildingAcronyms() {
        return buildingRepository.findAll();
    }

    @GetMapping(value = "/buildings", params = "acronym")
    public Building getBuildingsByAcronym(@RequestParam(value = "acronym", required = true) String acronym) {
        return buildingRepository.findByAcronymIgnoreCase(acronym).orElseThrow(InvalidParameterException::new);
    }

    @GetMapping("/days")
    public List<DaysOfTheWeek> getAllDaysOfTheWeek(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return daysRepository.findAll();
    }

    @GetMapping(value = "/days", params = "q")
    public DaysOfTheWeek getDaysByQuery(String day) {
        return daysRepository.findByDay(day).orElseThrow(InvalidParameterException::new);
    }

    @GetMapping("/coursetypes")
    public List<CourseType> getAllCourseType(@RequestParam(value = "type", required = false) String type) {
        if (type != null) {
            return courseTypeRepository.findByTypeIgnoreCase(type);
        }
        return courseTypeRepository.findAll();
    }

    @GetMapping("/loi")
    public List<LanguageOfInstruction> getAllLoi(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return loiRepository.findAll();
    }

    @GetMapping(value = "/loi", params = "name")
    public LanguageOfInstruction getLoiByName(@RequestParam(value = "name") String name) {
        return loiRepository.findByLoi(name).orElseThrow(InvalidParameterException::new);
    }

    @GetMapping("/terms")
    public List<Term> getAllTerm(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return termRepository.findAll();
    }

    @GetMapping(value = "/terms", params = "q")
    public Term getTermByQuery(@RequestParam(value = "q") String query) {
        return termRepository.findByTerm(query).orElseThrow(InvalidParameterException::new);
    }

}
