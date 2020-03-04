package com.easyyu.api.buildings;

import com.easyyu.api.buildings.athletic.AthleticBuilding;
import com.easyyu.api.buildings.athletic.AthleticBuildingRepository;
import com.easyyu.api.buildings.food.FoodBuilding;
import com.easyyu.api.buildings.food.FoodBuildingRepository;
import com.easyyu.api.buildings.food.WaterRefill;
import com.easyyu.api.buildings.food.WaterRefillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buildings")
public class BuildingController {

    @Autowired
    private WaterRefillRepository waterRefillRepository;

    @Autowired
    private FoodBuildingRepository foodBuildingRepository;

    @Autowired
    private AthleticBuildingRepository athleticBuildingRepository;

    @GetMapping("/waterstations")
    public List<WaterRefill> getAllWaterStations(@RequestParam(value = "campus", required = false) String campus) {
        if (campus == null) {
            return waterRefillRepository.findAll();
        } else {
            return waterRefillRepository.findByCampusIgnoreCase(campus);
        }
    }

    @GetMapping("/food")
    public List<FoodBuilding> getAllFoodBuilding() {
        return foodBuildingRepository.findAll();
    }

    @GetMapping("/athletic")
    public List<AthleticBuilding> getAllAthleticBuilding() {
        return athleticBuildingRepository.findAll();
    }
}
