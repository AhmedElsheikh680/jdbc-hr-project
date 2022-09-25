package com.hr.repo;

import com.hr.config.HRStatisticProjection;
import com.hr.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDataJDBCRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingAndDepartmentNameContaining(String empName, String deptName);


    Long countByNameContainingAndDepartmentNameContaining(String empName, String deptName);

    List<Employee> findBySalary(Double salary, String name);

    @Query(value = "select (select count(*) from department) deptCount,"
            +"(select COUNT(*) from employee) empCount,"
            +"(select COUNT(*) from sec_user) userCount", nativeQuery = true)
    HRStatisticProjection getHRStatistic();


    // Using JPQL
    @Query(value = "select emp from Employee emp where emp.name= :empName and emp.salary= :salary")
    List<Employee> filter(@Param("empName") String name, Double salary);



//    List<Employee> findByNameStartingWith(String name);
//
//    @Query(value = "select * from employee where name LIKE :empName AND salary >= :empSalary")
//    List<Employee> findByNameContainingAndSalaryGreaterThanEqual(@Param("empName") String name,@Param("empSalary") Double salary);
//
//    @Modifying
//    @Query("update employee set salary= :salary where id= :id")
//    int updateSalary(Double salary, Long id);
}
