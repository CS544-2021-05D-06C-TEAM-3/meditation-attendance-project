package edu.miu.attendance.repository;

import edu.miu.attendance.domain.CourseOffering;
import edu.miu.attendance.domain.Registration;
import edu.miu.attendance.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    List<Registration> findAllRegistrationByStudent(Student student);

    List<Registration> findAllRegistrationByCourseOffering(CourseOffering courseOffering);
}
