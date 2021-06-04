package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Location;

public interface LocationRepository extends CrudRepository<Location, String> {

}
