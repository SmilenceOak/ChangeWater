package com.geyan.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geyan.dao.UserDao;
import com.geyan.model.User;
import com.geyan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	UserDao userDao;
	
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}

	public List<User> getUserByLimit(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return userDao.getUserByLimit(map);
	}

	
}
