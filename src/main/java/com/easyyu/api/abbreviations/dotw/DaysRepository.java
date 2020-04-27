package com.easyyu.api.abbreviations.dotw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DaysRepository extends JpaRepository<DaysOfTheWeek, Long> {
    Optional<DaysOfTheWeek> findByDay(String day);
}
