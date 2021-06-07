package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.*;
import edu.miu.attendance.repository.CourseOfferingRepository;
import edu.miu.attendance.repository.FacultyRepository;
import edu.miu.attendance.repository.RegistrationRepository;
import edu.miu.attendance.service.FacultyService;
import edu.miu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    StudentService studentService;
    @Override
    public Faculty getFacultyByUsername(String username) {
        return facultyRepository.findByUsername(username);
    }

    @Override
    public Faculty getFacultyById(long id) {
        return facultyRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudentForFaculty(long id) {
        List<Student> studentList=new ArrayList<>();
        List<Registration> registrationList=new ArrayList<>();
        List<CourseOffering> courseOfferingList= findCourseOfferingByFaculty(id);

        for(CourseOffering courseOffering:courseOfferingList){
            for (Registration registration:courseOffering.getRegistrations()){
                registrationList.add(registration);
            }
        }
        for (Registration registration:registrationList){
            studentList.add(registration.getStudent());
        }
        return studentList;
    }

    @Override
    public List<Course> findCoursesByFaculty(long id) {
        Faculty faculty = getFacultyById(id);
        return courseOfferingRepository.getCourseOfferingsByFaculty(faculty)
                .stream()
                .map(courseOffering -> courseOffering.getCourse()).collect(Collectors.toList());
    }

    @Override
    public List<CourseOffering> findCourseOfferingByFaculty(long id) {
        Faculty faculty = getFacultyById(id);
        return courseOfferingRepository.getCourseOfferingsByFaculty(faculty);
    }

//    @Override
//    public void changeStudentAttendanceStatus(long id, String status) {
//        Student student = studentService.getStudentById(id);
//        studentService.changeStudentAttendanceStatus(student,status);
//
//    }
}
