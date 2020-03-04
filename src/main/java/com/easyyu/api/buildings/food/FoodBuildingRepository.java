package com.easyyu.api.buildings.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodBuildingRepository extends JpaRepository<FoodBuilding, Integer> {
}
