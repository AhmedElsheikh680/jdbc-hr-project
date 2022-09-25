package com.hr.service;


import com.hr.config.HRStatisticProjection;
import com.hr.model.Employee;
import com.hr.repo.EmployeeDataJDBCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDataJDBCRepo employeeDataJDBCRepo;

    @Autowired
    private DepartmentService departmentService;

    public List<Employee> findByEmpDeptName(String empName, String deptName) {
        return employeeDataJDBCRepo.findByNameContainingAndDepartmentNameContaining(empName, deptName);
    }

    public Long countByEmpDeptName(String empName, String deptName) {
        return employeeDataJDBCRepo.countByNameContainingAndDepartmentNameContaining(empName, deptName);
    }

    public List<Employee> findBySalary(Double salary, String name ) {
        return employeeDataJDBCRepo.findBySalary(salary, name);
    }

    public HRStatisticProjection getHRStatistic() {
        return employeeDataJDBCRepo.getHRStatistic();
    }


    public List<Employee> filter(String name, Double salary) {
        return employeeDataJDBCRepo.filter(name, salary);
    }



    public Employee findById(Long id) {
        return employeeDataJDBCRepo.findById(id).orElseThrow();
    }

    public Employee save(Employee employee) {

        if(employee.getDepartment() !=null && employee.getDepartment().getId() !=null) {
            employee.setDepartment(departmentService.findById(employee.getDepartment().getId()));
        }
        return employeeDataJDBCRepo.save(employee);
    }

    public Employee update(Employee employee) {
        Employee currentEmployee = employeeDataJDBCRepo.findById(employee.getId()).get();
        currentEmployee.setName(employee.getName());
        currentEmployee.setSalary(employee.getSalary());
        currentEmployee.setDepartment(employee.getDepartment());
        return employeeDataJDBCRepo.save(currentEmployee);
    }
}
