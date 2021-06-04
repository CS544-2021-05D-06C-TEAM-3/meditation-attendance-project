package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Location;

public interface LocationRepository extends JpaRepository<Location, String> {

}
