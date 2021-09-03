package com.example.demo.controller.exercise;

public class SafeThread {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    private int count = 0;

    public void calc(){
        threadLocal.set(count + 1);
    }

    public int getCount(){
        Integer integer = threadLocal.get();
        return integer != null ? integer :0;
    }

    public static void main(String[] args) throws InterruptedException {
        SafeThread safeThread = new SafeThread();
        for (int i = 0; i < 20;i++){
            new ThreadB(i,safeThread).start();
        }
        Thread.sleep(200);
        System.out.println("readCount:"+safeThread.getCount());
    }
}

class ThreadB extends Thread{

    private int i ;

    private SafeThread safeThread;

    ThreadB(int i, SafeThread safeThread){
        this.i = i;
        this.safeThread = safeThread;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        safeThread.calc();

        System.out.println("i:"+i+",count:"+safeThread.getCount());
    }
}
