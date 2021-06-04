package edu.miu.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import edu.miu.attendance.domain.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

}
