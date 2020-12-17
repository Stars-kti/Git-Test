package com.management.service.imp;

import com.citic.common.util.object.ObjUtils;
import com.management.dao.UserDao;
import com.management.entity.user.User;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryAllUsers(String userName, String roleName) {
        if (!ObjUtils.isEmpty(userName) && !ObjUtils.isEmpty(roleName)) {

        }
        else if (!ObjUtils.isEmpty(userName) && ObjUtils.isEmpty(roleName)) {
            userDao.findAllByUsernameIsLike("%" + userName + "%");
        }
        else if (ObjUtils.isEmpty(userName) && !ObjUtils.isEmpty(roleName)) {

        }
        return userDao.findAll();
    }
}
