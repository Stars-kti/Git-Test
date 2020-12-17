package com.management.dto.user;


import com.management.entity.user.JWT;
import com.management.entity.user.User;

public class LoginDTO {
    private User user;
    private JWT jwt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JWT getJwt() {
        return jwt;
    }

    public void setJwt(JWT jwt) {
        this.jwt = jwt;
    }
}
