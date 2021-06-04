package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.BarcodeRecord;

public interface BarcodeRecordRepository extends JpaRepository<BarcodeRecord,String> {

}
