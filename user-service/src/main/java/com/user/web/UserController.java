package com.user.web;


import com.user.dto.RespDTO;
import com.user.dto.UserLoginDTO;
import com.user.entity.JWT;
import com.user.entity.User;
import com.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;
import util.security.BPwdEncoderUtils;
import util.security.UserUtils;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "注册", notes = "username和password为必选项")
    @PostMapping("/registry")
    public User createUser(User user){
        String entryPassword= BPwdEncoderUtils.bCryptPassword(user.getPassword());
        user.setPassword(entryPassword);
        return userService.createUser(user);
    }

    @ApiOperation(value = "登录", notes = "username和password为必选项")
    @PostMapping("/login")
    public UserLoginDTO login(@RequestParam String username , @RequestParam String password) {
      return   userService.login(username,password);
    }

    @ApiOperation(value = "根据用户名获取用户", notes = "根据用户名获取用户")
    @PostMapping("/{username}")
    @PreAuthorize("hasRole('USER')")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public RespDTO getUserInfo(@PathVariable("username") String username){


        List<SimpleGrantedAuthority> currentAuthorities = UserUtils.getCurrentAuthorities();
        User user=  userService.getUserInfo(username);
        return RespDTO.onSuc(user);
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PostMapping("/changePassword")
    public RespDTO changePassword(String oldPassword, String newPassword) {
        User user = userService.changePassword(oldPassword, newPassword);
        return RespDTO.onSuc(user);
    }

//    @ApiOperation(value = "注销", notes = "注销")
//    @PostMapping("/logout")
//    public RespDTO logout(){
//        String logout = userService.logout();
//        return RespDTO.onSuc(logout);
//    }

    @ApiOperation(value = "刷新Token" , notes = "access_token过期后，采用refresh_token重新获取，不需要携带access_token")
    @ApiParam(name = "refresh_token", value = "refresh_ token")
    @PostMapping("refreshToken")
    public RespDTO refreshToken(String refreshToken) {
        JWT jwt = userService.refreshToken(refreshToken);
        return RespDTO.onSuc(jwt);
    }
}
