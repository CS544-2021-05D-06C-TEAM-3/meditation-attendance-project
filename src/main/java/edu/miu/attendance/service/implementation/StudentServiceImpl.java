package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.Registration;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.model.StudentRequest;
import edu.miu.attendance.repository.RegistrationRepository;
import edu.miu.attendance.repository.StudentRepository;
import edu.miu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentDAO;

    @Autowired
    RegistrationRepository registrationDAO;


    @Override
    public Student registerStudent(StudentRequest student) {
        Student newStudent = new Student();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setEntry(student.getEntry());
        newStudent.setBarcode(student.getBarcode());
        return studentDAO.save(newStudent);
    }

    @Override
    public Student findStudentById(long id) {
        return studentDAO.findById(id).orElseThrow();
    }

    @Override
    public void deleteStudentById(long id) {
        studentDAO.deleteById(id);
    }

    @Override
    public List<Course> getAllCoursesByStudent(long id) {
        Student student = findStudentById(id);
        return registrationDAO.findAllRegistrationByStudent(student).stream()
                .map(registration -> registration.getCourseOffering().getCourse()).collect(Collectors.toList());
    }
}
