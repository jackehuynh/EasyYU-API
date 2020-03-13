package com.easyyu.api.abbreviations;

import com.easyyu.api.abbreviations.repository.BuildingRepository;
import com.easyyu.api.abbreviations.repository.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "${api_url}/abbreviations")
public class AbbreviationController {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private DaysRepository daysRepository;

    @GetMapping("/buildings")
    public List<Building> getAllBuildingAcronyms(@RequestParam(value = "acronym", required = false) String acronym) {
        if (acronym != null) {
            return buildingRepository.findByAcronymIgnoreCase(acronym);
        }
        return buildingRepository.findAll();
    }

    @GetMapping("/days")
    public List<DaysOfTheWeek> getAllDaysOfTheWeek() {
        return daysRepository.findAll();
    }
}
