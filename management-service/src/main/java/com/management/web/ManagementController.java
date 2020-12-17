package com.management.web;

import com.citic.common.annotation.Log;

import com.management.dto.system.RespDTO;
import com.management.entity.user.Role;
import com.management.entity.user.User;
import com.management.service.RoleService;
import com.management.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.security.CheckPassword;
import util.security.UserUtils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/system")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
@Api(tags = "系统管理")
public class ManagementController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Log("查询当前用户信息")
    @ApiOperation(value = "获取当前用户所有权限", notes = "获取当前用户所有权限")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/authority", method = RequestMethod.POST)
    public List authority(){
        List<SimpleGrantedAuthority> currentAuthorities = UserUtils.getCurrentAuthorities();
        List<String> authority = new ArrayList<>();
        currentAuthorities.forEach( simpleGrantedAuthority -> {
            authority.add(simpleGrantedAuthority.getAuthority());
        });
        return authority;
    }

    @Log("查询所有用户")
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public RespDTO queryAllUsers(String userName, String roleName) {
        List<User> users = userService.queryAllUsers(userName, roleName);
        return RespDTO.onSuc(users);
    }

    @Log("查询所有权限信息")
    @ApiOperation(value = "查询所有权限信息", notes = "权限信息")
    @ApiParam(value = "权限名称", name = "roleName")
    @RequestMapping(value = "roles", method = RequestMethod.POST)
    public RespDTO queryAllRoles(String roleName) {
        List<Role> roles = roleService.queryAllRole(roleName);
        return RespDTO.onSuc(roles);
    }

    @ApiOperation(value = "查询所有权限信息", notes = "权限信息")
    @RequestMapping(value = "checkPassword", method = RequestMethod.POST)
    public RespDTO checkPassword(String password) {

        return RespDTO.onSuc(CheckPassword.checkPassword(password));
    }

}
