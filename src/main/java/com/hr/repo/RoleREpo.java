package com.hr.repo;

import com.hr.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleREpo extends JpaRepository<Role, Long> {
}
