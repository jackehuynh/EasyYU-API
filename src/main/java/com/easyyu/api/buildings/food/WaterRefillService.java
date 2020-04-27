package com.easyyu.api.buildings.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class WaterRefillService {

    @Autowired
    private WaterRefillRepository waterRefillRepository;

    public List<WaterRefill> findByCampus(String campus) {
        if (campus.equalsIgnoreCase("keele") || campus.equalsIgnoreCase("glendon")) {
            return waterRefillRepository.findByCampusIgnoreCase(campus);
        }
        throw new InvalidParameterException();
    }

    public List<WaterRefill> findAll() {
        return waterRefillRepository.findAll();
    }
}
