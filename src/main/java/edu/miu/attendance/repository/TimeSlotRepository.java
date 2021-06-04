package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.TimeSlot;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, String> {

}
