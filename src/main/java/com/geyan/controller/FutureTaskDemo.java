package com.geyan.controller;

import java.util.concurrent.*;

/**
 * @program: ChangeWater
 * @description: Future和Callable的使用
 * @author: geyan
 * @create: 2018-05-10 16:31
 **/
public class FutureTaskDemo {

    public static void main( String[] args ) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //创建一个Callable 用于执行一个耗时的任务
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("执行了callable");
                Thread.sleep(3000);
                return Thread.currentThread().getName();
            }
        };
        //创建FutureTask 可以返回线程执行的结果
        FutureTask<String> task1 = new FutureTask<>(call);
        //task1.run(); //可以执行callable 但是此种方法失去了异步的意义 还是会等meth主线程调用完call才会继续往下执行
        new Thread(task1).start();//此种方法异步去执行call 不会阻塞下面的 do soing
       // executorService.execute(task1);
        System.out.println("do something");
        try {
            String result = task1.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
    }

}
