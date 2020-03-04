package com.easyyu.api.buildings.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterRefillRepository extends JpaRepository<WaterRefill, Integer> {
    List<WaterRefill> findByCampusIgnoreCase(String campus);
}
