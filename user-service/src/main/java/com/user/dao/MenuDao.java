package com.user.dao;

import com.user.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDao extends JpaRepository<Menu, Long> {

    @Query( value = "SELECT DISTINCT m1.id,m1.path,m1.`name`,m1.detail,m1.parent_id,m1.require_auth,m1.enabled " +
            "FROM menu m1,user_role ur,menu_role mr " +
            "WHERE ur.role_id=mr.role_id AND ur.user_id = ?1 " +
            "AND m1.enabled=TRUE AND mr.`menu_id`=m1.`id` " +
            "ORDER BY m1.id",nativeQuery = true)
    List<Menu> findMenuInAuth(Long uid);

//    @Query( value = "SELECT DISTINCT m1.*,m2.* FROM menu m1, menu m2,user_role ur,menu_role mr " +
//            "WHERE m1.id=m2.parent_id AND m1.require_auth=FALSE AND m2.require_auth=FALSE " +
//            "AND m1.enabled=TRUE AND m2.enabled=TRUE ORDER BY m1.`id`,m2.`id`",nativeQuery = true)
//    List<Menu> findMenuNotInAuth();

}
