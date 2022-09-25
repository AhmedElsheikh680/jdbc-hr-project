package com.hr.controller;

import com.hr.dto.EmployeeDTO;
import com.hr.model.Employee;
import com.hr.repo.EmployeeDataJDBCRepo;
import com.hr.repo.EmployeeRepo;
import com.hr.service.EmployeeService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/emp/")
//@Controller
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
//    @Autowired
//    @Qualifier("employeeNamedParameterJDBCRepoImpl")
//    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDataJDBCRepo employeeDataJDBCRepo;

//    @GetMapping("/count")
//    public int countEmployees() {
//        return employeeRepo.count();
//    }

//    @GetMapping("{id}")
//    public Employee employee(@PathVariable Long id){
//        return employeeRepo.findById(id);
//    }
//
//    @GetMapping("")
//    public List<Employee> emps() {
//        return employeeRepo.findAll();
//
//    }

//    @GetMapping("/emp/{name}")
//    @ResponseBody
//    public List<Employee> filter(@PathVariable String name) {
//        return employeeDataJDBCRepo.findByNameStartingWith(name);
//    }
//
//    @GetMapping("/emp/{name}/{salary}")
//    @ResponseBody
//    public List<Employee> findEmpByNameAndSalary(@PathVariable String name, @PathVariable Double salary) {
//        return employeeDataJDBCRepo.findByNameContainingAndSalaryGreaterThanEqual(name, salary);
//    }
//    @GetMapping("/emp")
//    @ResponseBody
//    public ResponseEntity<?> getEmp(@RequestParam Long id, @RequestHeader("Accept-Language") String acceptLanguage) {
//        logger.info("Accept Language: "+ acceptLanguage);
//        return new ResponseEntity<>(employeeDataJDBCRepo.findById(id).get(), HttpStatus.OK);
//    }

    @GetMapping("/emp")
    public EmployeeDTO findEmp(@RequestParam Long id) {
       Employee employee =  employeeService.findById(id);
       EmployeeDTO employeeDTO = new EmployeeDTO();
       employeeDTO.setId(employee.getId());
       employeeDTO.setName(employee.getName());
       employeeDTO.setDepartment(employee.getDepartment());
       employeeDTO.setUser(employee.getUser());
       return employeeDTO;
    }

    @GetMapping("/emp-dept")
    public List<Employee> findByEmpDeptName(@RequestParam String empName, @RequestParam String deptName) {
        return employeeService.findByEmpDeptName(empName, deptName);
    }

    @GetMapping("/emp-salary")
    public ResponseEntity<?> findBySalary(@RequestParam Double salary, @RequestParam String name) {
        return ResponseEntity.ok(employeeService.findBySalary(salary, name));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filter(@RequestParam String name, @RequestParam Double salary) {

        return ResponseEntity.ok(employeeService.filter(name, salary));
    }

    @GetMapping("/hr-statistic")
    public ResponseEntity<?> getHRStatistic() {
        return ResponseEntity.ok(employeeService.getHRStatistic());
    }

    @GetMapping("/count-emp-dept")
    public ResponseEntity<Long> contByEmpDeptName(@RequestParam String empName, @RequestParam String deptName) {
        return  ResponseEntity.ok(employeeService.countByEmpDeptName(empName, deptName));
    }

    @PostMapping("/emp")
    public Employee addEmp(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/emp")
    public Employee updateEmp(@RequestBody Employee employee) {
        return employeeDataJDBCRepo.save(employee);
    }
//    @ResponseBody
//    @PutMapping("/salary")
//    public int updateSalary(@RequestParam Double salary, @RequestParam Long id) {
//        return employeeDataJDBCRepo.updateSalary(salary, id);
//    }

    @DeleteMapping("/emp/{empId}")
    public void deleteEmp(@PathVariable(name = "empId") Long id) {
        employeeDataJDBCRepo.deleteById(id);
    }














}
