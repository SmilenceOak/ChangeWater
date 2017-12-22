package com.geyan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geyan.model.User;
import com.geyan.service.UserService;


@Controller  		
public class UserController {
	
	@Resource UserService userService;
	
	CountDownLatch cd = new CountDownLatch(5);
	
	static final int limit = 2000;
	
	static final int threads = 5;
	
	static ExecutorService ss = new ThreadPoolExecutor(threads, threads, 60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
	
	@RequestMapping("/getDate.htm")
	public void updateUser(){
		
		 final CountDownLatch cd = new CountDownLatch(threads);
		Date start = new Date();
		System.out.println();
//	    List<User> userList = userService.getUser();
//		System.out.println(userList.size());
		
		//ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 3000, null, null, null, null);
//		executor.execute(new Runnable() {
//			
//			public void run() {
//				for(int i = 0 ; i< userList.size() ;i++){
//					User user = userList.get(i);
//					user.setPassword("1");
//					userService.updateUser(user);
//				}
//				
//			}
//		});
		
		for(int i = 0 ; i< threads ;i++){
			final int page = i*limit;
			ss.execute(new Runnable() {
				public void run() {
						String name = Thread.currentThread().getName();
						System.out.println(name);
						HashMap<String, Integer> params = new HashMap<String, Integer>();
						params.put("page", page);
						params.put("pageNum", limit);
						 List<User> userListLimit = userService.getUserByLimit(params);
						 for(User user: userListLimit){
							 user.setPassword(name);
							 userService.updateUser(user);
						 }
						 cd.countDown();
				}
				//cd.countDown();
			});
		}
		
		try {
			cd.await();
			Date end = new Date();
			long time = end.getTime()-start.getTime();
			System.out.println("共执行了【"+(time)+"毫秒】");
			System.out.println("======================");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class MyThreadTest{
		
		
	}
}

