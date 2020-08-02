package com.easyyu.api.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
    Optional<Subject> findBySubjectAllIgnoreCase(String subject);
}
