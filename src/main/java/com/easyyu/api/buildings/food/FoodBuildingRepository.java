package com.easyyu.api.buildings.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodBuildingRepository extends JpaRepository<FoodBuilding, String> {
     List<FoodBuilding> findByCampusIgnoreCase(String campus);
}
