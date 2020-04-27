package com.easyyu.api.abbreviations.loi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoiRepository extends JpaRepository<LanguageOfInstruction, String> {
    Optional<LanguageOfInstruction> findByLoi(String name);
}
