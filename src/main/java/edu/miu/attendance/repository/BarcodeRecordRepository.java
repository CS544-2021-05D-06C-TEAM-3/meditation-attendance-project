package edu.miu.attendance.repository;

import edu.miu.attendance.domain.Location;
import edu.miu.attendance.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.BarcodeRecord;

import java.util.List;

public interface BarcodeRecordRepository extends JpaRepository<BarcodeRecord,Long> {

    List<BarcodeRecord> findAllByStudent(Student student);

    BarcodeRecord findFirstByStudent(Student student);


}
