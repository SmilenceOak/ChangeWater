package com.geyan.controller;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public  int inc = 0;
    
   private static  CountDownLatch cd = new CountDownLatch(100);
    
   Lock lock = new ReentrantLock();
   
    public synchronized void  increase() {
    	try {
			inc++;
		//	System.out.println("222222222222222");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
    }
 
    public static void main(String[] args) {
        final Test test = new Test();
        for(int i=0;i<100;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10000;j++){
                    	test.increase();
                    }
                    try {
                    	cd.countDown();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                };
            }.start();
        }
 
        try {
			cd.await();
			System.out.println(test.inc);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}