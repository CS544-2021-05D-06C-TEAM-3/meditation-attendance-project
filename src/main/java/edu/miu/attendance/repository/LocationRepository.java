package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
