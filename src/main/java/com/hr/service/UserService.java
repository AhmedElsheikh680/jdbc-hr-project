package com.hr.service;


import com.hr.model.Department;
import com.hr.model.User;
import com.hr.repo.DepartmentRepo;
import com.hr.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public List<User> findALl() {
        return userRepo.findAll();
    }
    public User save(User user) {
        return userRepo.save(user);
    }

    public User update(User user) {
        User currentUser = userRepo.findById(user.getId()).orElseThrow();
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());

        return userRepo.save(currentUser);
    }
}
