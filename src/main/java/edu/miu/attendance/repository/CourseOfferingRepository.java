package edu.miu.attendance.repository;

import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.Faculty;
import edu.miu.attendance.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.CourseOffering;

import java.util.List;

public interface CourseOfferingRepository extends JpaRepository<CourseOffering, String> {

    List<CourseOffering> findCourseOfferingByFaculty(Faculty faculty);
    List<CourseOffering> findCourseOfferingByStudent(Student student);
}
