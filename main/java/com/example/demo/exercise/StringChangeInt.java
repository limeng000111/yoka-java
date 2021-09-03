package com.example.demo.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringChangeInt {
    @Test
    public void changeInt(){
        //定义一个String类型的id
        String id = "123";
        //转换成int并输出
        int intId = Integer.parseInt(id);
//        System.out.println(intId);
        String stringId = String.valueOf(intId);
        String stringId1 = intId + "";
        String stringId2 = Integer.toString(intId);
        System.out.println("stringId:"+stringId);
        System.out.println("stringId1:"+stringId1);
        System.out.println("stringId2:"+stringId2);

        //新建一个数组
        String[] a = new String[]{"aaa","bbb","ccc"};
        //数组转换为列表
        List<String> arrayToList = new ArrayList<>(Arrays.asList(a));
        String b = arrayToList.get(1);
        System.out.println("列表中的值："+b);
    }
}
