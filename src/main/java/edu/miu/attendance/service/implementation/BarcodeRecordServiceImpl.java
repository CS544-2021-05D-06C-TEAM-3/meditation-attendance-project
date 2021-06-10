package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.BarcodeRecord;
import edu.miu.attendance.domain.Location;
import edu.miu.attendance.domain.Student;

import edu.miu.attendance.model.BarcodeRequest;
import edu.miu.attendance.repository.BarcodeRecordRepository;
import edu.miu.attendance.repository.LocationRepository;
import edu.miu.attendance.security.SecurityUtils;
import edu.miu.attendance.service.BarcodeRecordService;
import edu.miu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BarcodeRecordServiceImpl implements BarcodeRecordService {


    @Autowired
    BarcodeRecordRepository barcodeRecordDAO;

    @Autowired
    StudentService studentService;

    @Autowired
    LocationRepository locationDAO;

    @Override
    public BarcodeRecord addBarcodeRecord(BarcodeRequest barcode) {
        String username = SecurityUtils.getUsername();
        Student student = studentService.findByUsername(username);
        List<Location> locations = locationDAO.findAll();
        System.out.println("locations" + locations);
        System.out.println("username" + username);
        System.out.println("barcodeRequest" + barcode);
        BarcodeRecord newBarcodeRecord = new BarcodeRecord();
        newBarcodeRecord.setStudent(student);
        newBarcodeRecord.setLocation(barcode.getLocation());
        newBarcodeRecord.setTimeSlot(barcode.getSlot());
        newBarcodeRecord.setDate(barcode.getDate());
        System.out.println("location" + barcode.getLocation());
        return barcodeRecordDAO.save(newBarcodeRecord);
    }

    @Override
    public List<BarcodeRecord> findAllByStudent(Student student) {
        return barcodeRecordDAO.findAllByStudent(student);
    }


}
