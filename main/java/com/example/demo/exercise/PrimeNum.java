package com.example.demo.exercise;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class PrimeNum {
    @Test
    public void testNum(){
        //统计n以内的质数
        int n = 1000;
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 2; i < n; i++){
            boolean flag = true;
            for (int j = 2;j < i;j++){
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                objects.add(i);
            }
        }
        System.out.println(n+"之内的质数为："+objects);
    }

    @Test
    public void yearNum(){
        //获取当天是全年的第n天
    }


}
