package com.example.demo.exercise;

public class Lambda {
    public static void main(String[] args) {
        //用匿名内部类的方式创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,my name is aaa");
            }
        });
        //使用Lambda创建线程
        new Thread(() -> System.out.println("hello,my name is bbb"));
    }
}
