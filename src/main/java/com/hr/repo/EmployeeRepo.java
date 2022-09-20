package com.hr.repo;

import com.hr.model.Employee;

import java.util.List;

public interface EmployeeRepo {

    int count();

    Employee findById(Long id);

    List<Employee> findAll();

    int insert(Employee employee);

    int update(Employee employee);
    int delete(Long id);
}
