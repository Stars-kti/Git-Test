package com.user.service.Impl;

import com.citic.common.exception.CommonException;
import com.citic.common.exception.enums.ErrorCode;
import com.user.client.AuthServiceClient;
import com.user.dao.MenuDao;
import com.user.dao.RoleDao;
import com.user.dao.UserDao;
import com.user.dto.UserLoginDTO;
import com.user.entity.JWT;
import com.user.entity.Menu;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import util.security.BPwdEncoderUtils;
import util.security.UserUtils;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    MenuDao menuDao;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    AuthServiceClient authServiceClient;

    @Override
    public User createUser(User user) {
        User username = userDao.findByUsername(user.getUsername());
        if (username != null) {
            throw new CommonException(ErrorCode.USERNAME_REPEAT);
        }
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        User save = userDao.save(user);
        save.setPassword(null);
        return save;
    }

    @Override
    public User getUserInfo(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserLoginDTO login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (null == user) {
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }
        if (!BPwdEncoderUtils.matches(password, user.getPassword())) {
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }

        JWT jwt = authServiceClient.getToken("jwt-server", "001206", "password", username, password);
        // 获得用户菜单
        if (null == jwt) {
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL, "服务器异常，请稍后再试");
        }
        Set<Menu> menus = new LinkedHashSet<>(menuDao.findMenuInAuth(user.getId()));
//        redisTemplate.opsForValue().set(user.getUsername(), jwt.getAccessToken(), 1, TimeUnit.HOURS);
//        redisTemplate.opsForValue().set(jwt.getAccessToken(), jwt.getAccessToken(), 1, TimeUnit.HOURS);
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        user.setPassword(null);
        userLoginDTO.setUser(user);
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setMenu(menus);
        return userLoginDTO;
    }

    @Override
    public User changePassword(String oldPassword, String newPassword) {
        String currentPrinciple = UserUtils.getCurrentPrinciple();
        User user = userDao.findByUsername(currentPrinciple);
        if (user == null) {
            throw new CommonException(ErrorCode.GET_USER_FAIL);
        }
        if (!BPwdEncoderUtils.matches(oldPassword, user.getPassword())) {
            throw new CommonException(ErrorCode.PASSWORD_ERROR, "旧密码错误");
        }
        user.setPassword(BPwdEncoderUtils.bCryptPassword(newPassword));
        return userDao.save(user);
    }

//    public String logout(){
//        String token = UserUtils.getCurrentToken();
//        Boolean delete = redisTemplate.delete(token);
//        return "注销成功";
//    }

    @Override
    public JWT refreshToken(String token) {
//        String token = UserUtils.getCurrentToken();
        JWT refreshToken = authServiceClient.getToken("refresh_token", token, "jwt-server", "0520");
        if (null == refreshToken) {
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        return refreshToken;
    }


}
