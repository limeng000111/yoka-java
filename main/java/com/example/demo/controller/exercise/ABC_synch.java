package com.example.demo.controller.exercise;

import org.junit.Test;

public class ABC_synch {
    @Test
    public void stringTest(){
        String a = " 1234567890aaaaa ";
        System.out.println("字符串a："+ a);
        //1、indexof:某个字符对应的索引
        System.out.println("a的索引值："+a.indexOf(3));
        //2、charat:某个索引的字符
        System.out.println("索引为9的字符："+a.charAt(9));
        //3、字符串的长度
        System.out.println("字符串的长度为："+a.length());
        //4、字符串首字母转换成大写
        System.out.println("首字母转换成大写："+a.toUpperCase());
        //5、字符串首字母转换成小写
        System.out.println("首字母转换成小写:"+a.toLowerCase());
        //6、字符串切割
        System.out.println("从char为8的部分切割："+a.split("8"));
        //7、字符串替换
        System.out.println("字符串将1替换成x："+a.replace("1","x"));
        //8、字符串截取
        System.out.println("截取索引从3-5的字符："+a.substring(3,5));
        //9、去除字符串两边的空格
        System.out.println("去完两边空格后的字符串："+a.trim());
        //10、转换成字符串的byte[]数组
        System.out.println(a.getBytes().toString());
        //11、比较两个字符串是否相等
        System.out.println("123123".equals(a));
    }
}
