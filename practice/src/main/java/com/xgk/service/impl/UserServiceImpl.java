package com.xgk.service.impl;

import java.util.List;

import com.xgk.dao.UserDao;
import com.xgk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.xgk.service.UserService;


@Service("userService")//服务类，注入id:userService
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
/*
 * 业务逻辑：在USER中插入数据 ，再在 USER2中插入一条数据
 */
	@Override
	public int addUser(User user) {
		userDao.addUser(user);
		return 1;
	}
	
//	public userDao getuserDao() {
//		return userDao;
//	}
//
//	public void setuserDao(userDao userDao) {
//		this.userDao = userDao;
//	}
	@Override
	public List<User> getUserListBy1(User user,Integer from,Integer pageSize) {
		return userDao.getUserListBy1(user,from,pageSize);
	}
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public Integer getUserByQuery(User queryUser) {
		return userDao.getUserCountByQuery(queryUser);
	}

	@Override
	public User checkUserCode(String userCode) {
		return userDao.checkUserCode(userCode);
	}
}
