package edu.miu.attendance.controller;


import edu.miu.attendance.domain.*;
import edu.miu.attendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/faculty/{id}/")
public class FacultyController {
    @Autowired
    RegistrationService registrationService;


    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseOfferingService courseOfferingService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BarcodeRecordService barcodeRecordService;

//    @GetMapping("/faculty/{studentId}")
//    public Student getStudentById(@PathVariable long studentId) {
//        return studentService.getStudentById(studentId);
//    }

    @GetMapping("/faculty/{id}/courses")
    public List<Course> getCoursesForFaculty(@PathVariable long id) {
        return facultyService.findCoursesByFaculty(id);
    }

    @GetMapping("/faculty/{id}/students")
    public List<Student> getAllStudent(@PathVariable long id) {
        return facultyService.getAllStudentForFaculty(id);
    }

//    @PutMapping("/faculty/{studentId}/{status}")
//    public void changeStudentAttendanceStatus(@PathVariable long studentId, @PathVariable String status) {
//         facultyService.changeStudentAttendanceStatus(studentId,status);
//    }




}
