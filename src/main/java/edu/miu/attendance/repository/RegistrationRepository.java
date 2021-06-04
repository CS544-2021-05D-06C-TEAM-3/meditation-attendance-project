package edu.miu.attendance.repository;

import edu.miu.attendance.domain.CourseOffering;
import edu.miu.attendance.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
    Student findByStudent(Student student);
    CourseOffering findByCourseOffering(CourseOffering courseOffering);

}
