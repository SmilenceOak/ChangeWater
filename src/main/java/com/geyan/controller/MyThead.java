package com.geyan.controller;

import javax.annotation.Resource;

import com.geyan.model.User;
import com.geyan.service.UserService;

public class MyThead extends Thread{
	
	@Resource
	private UserService userService;
	
	private User user;
	
	public MyThead(User user) {
		this.user = user;
	}
	
	@Override
	public void run() {
		userService.updateUser(user);
		
	}
	
}
