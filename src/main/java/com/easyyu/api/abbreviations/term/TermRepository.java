package com.easyyu.api.abbreviations.term;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TermRepository extends JpaRepository<Term, String> {
    Optional<Term> findByTerm(String term);
}
