package com.user.dao;


import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
	/**
	 * 通过用户名查询用户信息
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return
	 */
	User findById(Integer id);


}
