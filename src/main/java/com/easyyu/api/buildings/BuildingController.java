package com.easyyu.api.buildings;

import com.easyyu.api.buildings.athletic.AthleticBuilding;
import com.easyyu.api.buildings.athletic.AthleticBuildingRepository;
import com.easyyu.api.buildings.food.*;
import com.easyyu.exceptions.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping(path = "${api_url}/buildings")
public class BuildingController {

    @Autowired
    private WaterRefillService waterRefillService;

    @Autowired
    private FoodBuildingRepository foodBuildingRepository;

    @Autowired
    private AthleticBuildingRepository athleticBuildingRepository;

    @GetMapping("")
    public String defaultPage() {
        throw new ExceptionType.PageNotFoundException();
    }

    // TODO: edge case of user adding more than one param, do this for both /food and /waterstations
    @GetMapping("/waterstations")
    public List<WaterRefill> getAllWaterStations(@RequestParam(value = "campus", required = true) String campus) {
        return waterRefillService.findByCampusIgnoreCase(campus);
    }

    @GetMapping("/food")
    public List<FoodBuilding> getAllFoodBuilding(@RequestParam(value = "campus", required = true) String campus) {
        return foodBuildingRepository.findAll();
    }

    @GetMapping("/athletic")
    public List<AthleticBuilding> getAllAthleticBuilding(HttpServletRequest request) {
        /* Checks if additional queries are passed */
        String query = request.getQueryString();
        if (query != null) {
            throw new ExceptionType.InvalidParameterException();
        }
        return athleticBuildingRepository.findAll();
    }
}
