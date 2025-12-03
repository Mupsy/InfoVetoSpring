package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.CalculIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculIARepository extends JpaRepository<CalculIA, Long> {

}
