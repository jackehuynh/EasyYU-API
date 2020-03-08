package com.easyyu.api.abbreviations.repository;

import com.easyyu.api.abbreviations.DaysOfTheWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRepository extends JpaRepository<DaysOfTheWeek, Long> {
}
