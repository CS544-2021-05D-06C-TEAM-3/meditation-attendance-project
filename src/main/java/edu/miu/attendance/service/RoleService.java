package edu.miu.attendance.service;

import edu.miu.attendance.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
