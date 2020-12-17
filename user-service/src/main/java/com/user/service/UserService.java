package com.user.service;

import com.user.dto.UserLoginDTO;
import com.user.entity.JWT;
import com.user.entity.User;

public interface UserService {

    User createUser(User user);

    User getUserInfo(String username);

    UserLoginDTO login(String username , String password);

    User changePassword(String oldPassword, String newPassword);

    JWT refreshToken(String token);
}
