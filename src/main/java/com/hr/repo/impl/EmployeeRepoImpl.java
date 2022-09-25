package com.hr.repo.impl;

import com.hr.mapper.EmployeeMapper;
import com.hr.model.Employee;
import com.hr.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("employeeRepoImpl")
public class EmployeeRepoImpl implements EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
    }

    @Override
    public Employee findById(Long id) {
//        return jdbcTemplate.queryForObject("select id, name, salary from employee where id= ?", new Object[]{id},
//                (rs, rowNum)-> new Employee(rs.getLong("id"), rs.getString("name"), rs.getDouble("salary"))
//                );

        return jdbcTemplate.queryForObject("select id, name, salary from employee where id=?", new Object[]{id}, new EmployeeMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, Double salary) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select id, name, salary from employee", new EmployeeMapper());
    }

    @Override
    public int insert(Employee employee) {
        return jdbcTemplate.update("insert into employee(id, name, salary) values (?,?,?)", new Object[]{employee.getId(), employee.getName(), employee.getSalary()});
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employee set name=?, salary=? ", new Object[]{employee.getName(), employee.getSalary()});
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from employee where id=?", new Object[]{id});
    }
}
