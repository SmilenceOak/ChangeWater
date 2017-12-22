package com.geyan.dao;

import java.util.HashMap;
import java.util.List;

import com.geyan.model.User;



public interface UserDao {
	
	public void updateUser(User user);
	
	public List<User> getUser();
	
	public void insertUser(User user);

	public List<User> getUserByLimit(HashMap<String, Integer> map);
}