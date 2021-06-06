package edu.miu.attendance.controller;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Course;
import edu.miu.attendance.domain.Student;
import edu.miu.attendance.model.BarcodeRequest;
import edu.miu.attendance.model.StudentRequest;
import edu.miu.attendance.service.BarcodeRecordService;
import edu.miu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    BarcodeRecordService barcodeRecordService;

    @PostMapping("students/register")
    public Student registerStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.registerStudent(studentRequest);
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("students/{id}/courses")
    public List<Course> getCoursesForStudent(@PathVariable long id) {
        return studentService.getAllCoursesByStudent(id);
    }

    @PostMapping("students/{id}/checkinBarcode")
    public BarcodeRecord addBarcodeRecord(@PathVariable long id, BarcodeRequest barcodeRequest) {
        return barcodeRecordService.addBarcodeRecord(id, barcodeRequest);
    }

//    @GetMapping("student/{id}/attendances")
//    public List<BarcodeRecord> getAttendanceForStudent(@PathVariable long id){
//
//    }
}