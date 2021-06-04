package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.CourseOffering;

public interface CourseOfferingRepository extends JpaRepository<CourseOffering, String> {

}
