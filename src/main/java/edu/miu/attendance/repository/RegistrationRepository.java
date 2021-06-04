package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.attendance.domain.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, String> {

}
