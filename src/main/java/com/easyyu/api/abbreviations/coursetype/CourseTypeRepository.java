package com.easyyu.api.abbreviations.coursetype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, String> {
    List<CourseType> findByTypeIgnoreCase(String type);
}
