package com.hr.repo.impl;

import com.hr.mapper.EmployeeMapper;
import com.hr.model.Employee;
import com.hr.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("employeeNamedParameterJDBCRepoImpl")
public class EmployeeNamedParameterJDBCRepoImpl implements EmployeeRepo {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public int count() {
        return 0;
    }

    @Override
    public Employee findById(Long id) {
        return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employee where id= :id",new MapSqlParameterSource("id", id), new EmployeeMapper());
    }

    @Override
    public List<Employee> findByNameAndSalary(String name, Double salary) {
        MapSqlParameterSource mapParam = new MapSqlParameterSource();
        mapParam.addValue("name", name);
        mapParam.addValue("salary", salary);
        return namedParameterJdbcTemplate.query("select id, name, salary from employee where name= :name, salary= :salary",mapParam, new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        return namedParameterJdbcTemplate.query("select id, name, salary from employee", new EmployeeMapper());
    }

    @Override
    public int insert(Employee employee) {
        return namedParameterJdbcTemplate.update("insert into employee(id, name, salary) values(:id, :name, :salary)", new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int update(Employee employee) {
        return namedParameterJdbcTemplate.update("update employee set name= :name, salary= :salary ", new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public int delete(Long id) {
        return namedParameterJdbcTemplate.update("delete from employee where id= :id", new MapSqlParameterSource("id", id));
    }
}
