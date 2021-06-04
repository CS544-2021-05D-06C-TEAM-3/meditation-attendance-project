package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, String> {

}
