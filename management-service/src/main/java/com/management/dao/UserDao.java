package com.management.dao;

import com.management.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 通过username查询全部user
     */
    List<User> findAllByUsernameIsLike(String username);

    //通过外表role的nameZh查询全部user
//    List<User> findAllByRolesIsLikeAnd(String nameZh);

}