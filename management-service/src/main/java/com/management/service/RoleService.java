package com.management.service;


import com.management.entity.user.Role;

import java.util.List;

/**
 * @author chenjiaxing
 */
public interface RoleService {

    /**
     * 查询权限
     * @param roleName 权限名
     * @return List<Role>
     */
    List<Role> queryAllRole(String roleName);
}
