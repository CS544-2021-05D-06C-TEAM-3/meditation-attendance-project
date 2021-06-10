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


    @GetMapping("students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("students/register")
    public Student registerStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.registerStudent(studentRequest);
    }

    @GetMapping("students/courses")
    public List<Course> getCoursesForStudent() {
        return studentService.getAllCoursesByStudent();
    }

    @PostMapping("students/{id}/checkinBarcode")
    public BarcodeRecord addBarcodeRecord(@PathVariable long id, @RequestBody BarcodeRequest barcodeRequest) {
        return barcodeRecordService.addBarcodeRecord(id, barcodeRequest);
    }

    @GetMapping("students/{id}/barcodeRecords")
    public List<BarcodeRecord> getAllBarcodeRecordsOfStudent(@PathVariable long id){
        return studentService.getAllBarcodeRecordForStudent(id);

    }

    @GetMapping("students/{studentId}/courseOffering/{courseOfferingId}/barcodeRecords")
    public List<BarcodeRecord> getAttendanceForStudent(@PathVariable long studentId, @PathVariable long courseOfferingId) {
        return studentService.getAllBarcodeRecordForStudentByCourseOffering(courseOfferingId, studentId);
    }
}
