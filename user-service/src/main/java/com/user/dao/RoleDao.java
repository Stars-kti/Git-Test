package com.user.dao;

import com.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, Long> {

    List<Role> findAllByName(String name);
}
