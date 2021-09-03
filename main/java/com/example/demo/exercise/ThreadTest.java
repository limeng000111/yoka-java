package com.example.demo.exercise;

import org.junit.Test;

public class ThreadTest {
    @Test
    public void method1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在执行");
            }
        };

        //创建3个线程
        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        Thread t3 = new Thread(runnable,"t3");

        //开启线程,join()保证线程按顺序执行
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
