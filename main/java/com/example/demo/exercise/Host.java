package com.example.demo.exercise;
//真实房东，需要出租房子
public class Host implements Rent {

    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
