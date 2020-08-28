package com.easyyu.api.buildings;

import com.easyyu.api.buildings.athletic.AthleticBuilding;
import com.easyyu.api.buildings.athletic.AthleticBuildingRepository;
import com.easyyu.api.buildings.food.*;
import com.easyyu.exceptions.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
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
    private FoodBuildingService foodBuildingService;

    @Autowired
    private AthleticBuildingRepository athleticBuildingRepository;

    @GetMapping("")
    public String defaultPage() {
        throw new ExceptionType.PageNotFoundException();
    }

    @GetMapping(value = "/waterstations", params = "campus")
    public List<WaterRefill> getWaterStationsByCampus(@RequestParam(value = "campus") String campus) {
        return waterRefillService.findByCampus(campus);
    }

    @GetMapping("/waterstations")
    public List<WaterRefill> getAllWaterStations(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return waterRefillService.findAll();
    }

    @GetMapping(value = "/food", params = "campus")
    public List<FoodBuilding> getFoodBuildingByCampus(@RequestParam(value = "campus") String campus, HttpServletRequest req) {
        return foodBuildingService.findByCampus(campus);
    }

    @GetMapping("/food")
    public List<FoodBuilding> getAllFoodBuildings(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return foodBuildingService.findAll();
    }

    @GetMapping("/athletic")
    public List<AthleticBuilding> getAllAthleticBuilding(HttpServletRequest req) {
        if (req.getParameterMap().size() > 0) {
            throw new InvalidParameterException();
        }
        return athleticBuildingRepository.findAll();
    }
}
