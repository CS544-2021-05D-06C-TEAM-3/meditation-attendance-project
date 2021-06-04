package edu.miu.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.miu.attendance.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
