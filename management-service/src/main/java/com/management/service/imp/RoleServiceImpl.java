package com.management.service.imp;

import com.citic.common.util.object.ObjUtils;
import com.management.dao.RoleDao;
import com.management.entity.user.Role;
import com.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> queryAllRole(String roleName) {
        if (ObjUtils.isEmpty(roleName)) {
            return roleDao.findAll();
        }
//        return roleDao.findAllByNameZhIsLike("%" + roleName + "%");
    return null;
    }

}
