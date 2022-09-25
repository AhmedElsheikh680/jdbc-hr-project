//package com.hr.config;
//
//import com.hr.model.Role;
//import com.hr.model.User;
//import com.hr.service.RoleService;
//import com.hr.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class StartupApp implements CommandLineRunner {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//    @Override
//    public void run(String... args) throws Exception {
//
////        if (userService.findALl().isEmpty()){
//        //create Role
//
//        Role role = new Role();
//        role.setName("ADMIN");
//
//        Role role2 = new Role();
//        role2.setName("USER");
//
//        Set<Role> adminRole = new HashSet<>();
//        adminRole.add(role);
//
//        Set<Role> userRole = new HashSet<>();
//        userRole.add(role2);
//
//        //create Users
//        User user = new User();
//        user.setUsername("Mazen");
//        user.setPassword("123");
//        user.setRoles(adminRole);
//        userService.save(user);
//
//        User user2 = new User();
//        user2.setUsername("Wael");
//        user2.setPassword("123");
//        user2.setRoles(userRole);
//        userService.save(user2);
//
//    }
////}
//}
