package com.example.demo.controller.exercise;

public class UnsafeThread {

    private int count = 0;

    public void calc(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeThread unsafeThread = new UnsafeThread();
        for (int i = 0;i < 20;i++){
            new ThreadA(i,unsafeThread).start();
        }

        Thread.sleep(200);
        System.out.println("readCount:"+unsafeThread.getCount());
    }
}

class ThreadA extends Thread{

    private int i;

    private UnsafeThread unsafeThread;

    ThreadA(int i, UnsafeThread unsafeThread){
        this.i = i;
        this.unsafeThread = unsafeThread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        unsafeThread.calc();

        System.out.println("i:"+ i + ",count:" + unsafeThread.getCount());
    }
}
