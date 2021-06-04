package edu.miu.attendance.repository;

import edu.miu.attendance.domain.CourseOffering;
import edu.miu.attendance.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.CourseSession;

public interface CourseSessionRepository extends JpaRepository<CourseSession, String> {
    CourseOffering findByCourseOffering(CourseOffering courseOffering);
    TimeSlot findByCourseSession(CourseSession courseSession);
}
