package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.Role;
import edu.miu.attendance.repository.RoleRepository;
import edu.miu.attendance.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleDAO;


    @Override
    public List<Role> getAllRoles() {
        return roleDAO.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.findRoleByRole(name).get();
    }
}
