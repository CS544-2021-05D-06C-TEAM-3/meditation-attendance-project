package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.BarcodeRecord;

public interface BarcodeRecordRepository extends CrudRepository<BarcodeRecord,String> {

}
