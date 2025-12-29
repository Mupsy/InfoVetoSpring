package com.infoveto.classic.api.repository;

import com.infoveto.classic.api.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
	long countByUserId_Id(String userId);
	void deleteByUserId_Id(String userId);
	java.util.List<Appointments> findTop5ByUserId_IdOrderByDateAppointementDesc(String userId);
}
