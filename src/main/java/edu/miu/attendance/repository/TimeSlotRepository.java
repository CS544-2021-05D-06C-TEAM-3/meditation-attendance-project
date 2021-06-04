package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.miu.attendance.domain.TimeSlot;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, String> {

}
