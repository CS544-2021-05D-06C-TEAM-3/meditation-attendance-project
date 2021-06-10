package edu.miu.attendance.controller;


import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculty/{id}/courses")
    public List<Course> getCoursesForFaculty(@PathVariable long id) {
        return facultyService.findCoursesByFaculty(id);
    }

    @GetMapping("/faculty/courseOffering/{id}/students")
    public List<Student> getRegisteredStudentForFaculty(@PathVariable long id) {
        return facultyService.getAllStudentForFaculty(id);
    }

    @GetMapping("/faculty/{studentId}/student/courseOffering/{courseOfferingId}/barcodeRecords")
    public List<BarcodeRecord> getAttendanceForStudent(@PathVariable long studentId, @PathVariable long courseOfferingId){
        return facultyService.getBarcodeRecordsByCourseOfferingForFaculty(courseOfferingId,studentId);

    }


}
