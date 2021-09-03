package com.example.demo.controller.exercise;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();//创建condition
    @Test
    public void testLock(){
        try {
            lock.lock();
            condition.await();
            condition.signal();//唤醒
            for (int i = 0;i < 5;i++){
                System.out.println(Thread.currentThread().getName()+(i+1));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
