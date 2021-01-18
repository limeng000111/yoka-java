package com.example.demo.exercise;

/**
 *
 */
public class Singleton {
    private static volatile Singleton singleton = null;
    /**
     * 私有构造器
     */
    private Singleton(){

    }

    /**
     * 静态get方法
     * @return
     */
    public  Singleton  getInstance(){
        /**
         * 双重检验是否需要创建Singleton
         */
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}
