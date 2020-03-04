package com.easyyu.api.buildings.athletic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleticBuildingRepository extends JpaRepository<AthleticBuilding, String> {
}
