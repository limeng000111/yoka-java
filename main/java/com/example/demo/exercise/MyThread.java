package com.example.demo.exercise;

import org.testng.annotations.Test;
import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.concurrent.*;

public class MyThread  implements Callable {
    public MyThread(String s) {
    }
//    @Override
//    public void run(){
//        System.out.println("本方法继承了Thread");
//    }

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();
    }
    public void threadPool(int taskSize) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0;i < taskSize;i++){
            Callable c= new MyThread(i + "");
            Future submit = pool.submit(c);
            futures.add(submit);
        }
        pool.shutdown();
        for (Future f : futures){
            System.out.println("res:" + f.get().toString());
        }
    }

    @Override
    public Object call() throws Exception {
        return null;
    }

    @Test
    public void createThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+"is running");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}



