package com.hr.service;


import com.hr.model.Department;
import com.hr.model.Employee;
import com.hr.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department findById(long id) {
        return departmentRepo.findById(id).orElseThrow();
    }



    public Department save(Department department) {
        return departmentRepo.save(department);
    }

    public Department update(Department department) {
        Department currentDepartment = departmentRepo.findById(department.getId()).orElseThrow();
        currentDepartment.setName(department.getName());

        return departmentRepo.save(currentDepartment);
    }
}
