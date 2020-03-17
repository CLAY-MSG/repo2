package com.xgk.service;

import java.util.List;

import com.xgk.domain.User;


public interface UserService {
	
	User login(User user);
	int addUser(User user);
	int deleteUser(Integer id);
	int updateUser(User user);
	List<User> getUserList();
	List<User> getUserListBy1(User user, Integer from, Integer pageSize);
	User getUserById(Integer id);
	Integer getUserByQuery(User queryUser);
	User checkUserCode(String userCode);
	
}
