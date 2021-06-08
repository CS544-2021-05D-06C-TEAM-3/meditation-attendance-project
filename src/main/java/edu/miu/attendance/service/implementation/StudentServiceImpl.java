package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.*;
import edu.miu.attendance.model.StudentRequest;
import edu.miu.attendance.repository.BarcodeRecordRepository;
import edu.miu.attendance.repository.CourseOfferingRepository;
import edu.miu.attendance.repository.RegistrationRepository;
import edu.miu.attendance.repository.StudentRepository;
import edu.miu.attendance.service.CourseOfferingService;
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

    @Autowired
    CourseOfferingService courseOfferingService;

    @Autowired
    BarcodeRecordRepository barcodeRecordDAO;


    @Override
    public Student registerStudent(StudentRequest student) {
        Student newStudent = new Student();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setEntry(student.getEntry());
        newStudent.setBarcode(student.getBarcode());
        newStudent.setUsername(student.getUsername());
        newStudent.setPassword(student.getPassword());
        return studentDAO.save(newStudent);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.findAll();
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

    @Override
    public List<CourseOffering> getAllCourseOfferingsForStudent(long id) {
        Student student = findStudentById(id);
        return registrationDAO.findAllRegistrationByStudent(student).stream()
                .map(registration -> registration.getCourseOffering()).collect(Collectors.toList());
    }

    @Override
    public List<BarcodeRecord> getAllBarcodeRecordForStudentByCourseOffering(long courseOfferingId, long studentId) {
        CourseOffering courseOffering = courseOfferingService.getCourseOfferingById(courseOfferingId);
        Student student = findStudentById(studentId);
        List<BarcodeRecord> barcodeRecords = barcodeRecordDAO.findAllByStudent(student);


        return barcodeRecords.stream()
                .filter(barcodeRecord -> barcodeRecord.getDate().isBefore(courseOffering.getEnd_date())
                        && barcodeRecord.getDate().isAfter(courseOffering.getStart_date())).collect(Collectors.toList());
    }

    @Override
    public List<BarcodeRecord> getAllBarcodeRecordForStudent(long id) {
        Student student = findStudentById(id);
        return barcodeRecordDAO.findAllByStudent(student);
    }
}
