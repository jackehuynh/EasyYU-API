package com.easyyu.api.abbreviations.building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building, String> {
    Optional<Building> findByAcronymIgnoreCase(String acronym);
}
