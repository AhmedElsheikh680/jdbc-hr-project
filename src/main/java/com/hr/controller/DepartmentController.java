package com.hr.controller;


import com.hr.model.Department;
import com.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping()
    public Department update(@RequestBody Department department) {
        return departmentService.update(department);
    }
}
