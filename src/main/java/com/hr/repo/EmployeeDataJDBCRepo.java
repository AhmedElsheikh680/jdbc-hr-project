package com.hr.repo;

import com.hr.config.HRStatisticProjection;
import com.hr.model.Employee;

import com.hr.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

//    List<Employee> findBySalary(Double salary, String name);

    @Query(value = "select (select count(*) from department) deptCount,"
            +"(select COUNT(*) from employee) empCount,"
            +"(select COUNT(*) from sec_user) userCount", nativeQuery = true)
    HRStatisticProjection getHRStatistic();


    // Using JPQL
//    @Query(value = "select emp from #{#entityName} emp where (:empName is null or emp.name LIKE :empName)")
//    Page<Employee> filter(@Param("empName") String name, Pageable pageable);

    @Query(value = "select emp from Employee emp where(:empName is null or emp.name like :empName)")
    Page<EmployeeProjection> filter(@Param("empName") String name, Pageable pageable);



//    List<Employee> findByNameStartingWith(String name);
//
//    @Query(value = "select * from employee where name LIKE :empName AND salary >= :empSalary")
//    List<Employee> findByNameContainingAndSalaryGreaterThanEqual(@Param("empName") String name,@Param("empSalary") Double salary);
//
//    @Modifying
//    @Query("update employee set salary= :salary where id= :id")
//    int updateSalary(Double salary, Long id);
}
