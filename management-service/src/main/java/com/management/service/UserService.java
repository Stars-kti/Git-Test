package com.management.service;


import com.management.entity.user.User;

import java.util.List;

public interface UserService {

    //查询所有用户
    List<User> queryAllUsers(String userName, String roleName);
}
