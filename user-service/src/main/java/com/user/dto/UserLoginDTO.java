package com.user.dto;


import com.user.entity.Menu;
import com.user.entity.JWT;
import com.user.entity.User;
import java.util.Set;

public class UserLoginDTO {
    private User user;
    private JWT jwt;
    private Set<Menu> menus;

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


    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenu(Set<Menu> menus) {
        this.menus = menus;
    }
}
