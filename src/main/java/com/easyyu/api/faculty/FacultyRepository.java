package com.easyyu.api.faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {
    Optional<Faculty> findByCodeAllIgnoreCase(String code);
}
