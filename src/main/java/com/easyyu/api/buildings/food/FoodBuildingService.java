package com.easyyu.api.buildings.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class FoodBuildingService {

    @Autowired
    private FoodBuildingRepository foodBuildingRepository;

    public List<FoodBuilding> findByCampus(String campus) {
        if (campus.equalsIgnoreCase("keele") || campus.equalsIgnoreCase("glendon")) {
            return foodBuildingRepository.findByCampusIgnoreCase(campus);
        }
        throw new InvalidParameterException(campus);
    }

    public List<FoodBuilding> findAll() {
        return foodBuildingRepository.findAll();
    }
}
