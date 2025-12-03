package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.CanceledAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanceledAppointmentsRepository extends JpaRepository<CanceledAppointments, Long> {

}
