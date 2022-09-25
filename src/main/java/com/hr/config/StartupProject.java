//package com.hr.config;
//
//import com.hr.model.Employee;
//import com.hr.repo.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class StartupProject implements CommandLineRunner {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Qualifier("employeeNamedParameterJDBCRepoImpl")
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
//        jdbcTemplate.execute("CREATE TABLE employee(id SERIAL, name VARCHAR(255), salary NUMERIC(15, 2))");
//
//        if(employeeRepo.count() ==0) {
//            employeeRepo.insert(new Employee(10L, "Ahmed", 2000.0));
//            employeeRepo.insert(new Employee(20L, "Mohamed", 3000.0));
//            employeeRepo.insert(new Employee(30L, "Ali", 5000.0));
//            employeeRepo.insert(new Employee(40L, "Ayman", 8000.0));
//            employeeRepo.insert(new Employee(50L, "Samy", 2000.0));
//            employeeRepo.insert(new Employee(60L, "Helal", 11000.0));
//        }
//
//
//
//    }
//}
