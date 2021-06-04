package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.CourseOffering;

public interface CourseOfferingRepository extends CrudRepository<CourseOffering, String> {

}
