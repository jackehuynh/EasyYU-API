package com.easyyu.api.abbreviations.repository;

import com.easyyu.api.abbreviations.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, String> {
    List<Building> findByAcronymIgnoreCase(String acronym);
}
