package com.management.dao;

import com.management.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, Long> {


//    List<Role> findAllByNameZhIsLike(String nameZh);
}
