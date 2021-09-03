package com.example.demo.controller.exercise;

import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Date {
    @Test
    public void exerciseDate() throws ParseException {
//        java.util.Date date = new java.util.Date();
//        System.out.println(date.toString());
//        long longValue = date.getTime();
//        System.out.println("毫秒数："+longValue);
//        Calendar instance = Calendar.getInstance();
//        System.out.println("calendar的时间："+ instance);
//        int year = instance.get(Calendar.YEAR);
//        System.out.println("获取当前的年份："+year);
//        //创建格式化对象
//        String simpleDateFormat = new SimpleDateFormat().format(date);
//        System.out.println("格式化后的数据："+simpleDateFormat);

        //算一算来到这个世界多少天
        InputStream in = System.in;
        Scanner scanner = new Scanner(in);
        System.out.println("请输入您的出生年月日：");
        String s = scanner.next();
        System.out.println("您的输入为："+ s);

        //将字符串转化成一个日期
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parse = simpleDateFormat1.parse(s);

        //获取该日期的毫秒值
        long v1 = parse.getTime();

        //获取当前时间的毫秒值
        long v2 = System.currentTimeMillis();

        //毫秒值间的差值
        long v3 = v2-v1;

        //将毫秒值进行转换
        int result = (int) (v3/1000/60/60/24);
        System.out.println("您已经出生了："+ result);
    }
}
