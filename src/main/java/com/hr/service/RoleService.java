package com.hr.service;


import com.hr.model.Role;
import com.hr.model.User;
import com.hr.repo.RoleREpo;
import com.hr.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleREpo roleREpo;

    public Role save(Role role) {
        return roleREpo.save(role);
    }

    public Role update(Role role) {
        Role currentRole = roleREpo.findById(role.getId()).orElseThrow();
        currentRole.setName(role.getName());

        return roleREpo.save(currentRole);
    }
}
