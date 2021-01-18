package com.example.demo.controller.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class leetcode {
//    @Test
    public void minCount() {
        int[] coins = {0};
        int sum = 0;
        for (int i = 0; i < coins.length;i++){
            int coin = coins[i];
            if (coin < 3){
                sum += 1;
            }else {
                int num = coin / 2;
                if ((coin % 2) != 0){
                    num += 1;
                }
                sum = sum + num;
            }
        }
        System.out.println("总共需要取："+sum+"次");
    }


    @Test
    public void moveZeroes() {
        int[] nums = {12,4,0,7,0,78,6,0};
        int zeroNum = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                nums[i-zeroNum] = nums[i];
            }else {
                zeroNum += 1;
            }
        }
        while (zeroNum > 0){
            nums[nums.length-zeroNum] = 0;
            zeroNum--;
        }
        System.out.println("重新排序后的nums："+ nums);
    }

    @Test
    public void testList(){
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(111);
        objects.add(222);
        objects.add(333);
        objects.add(444);
        Iterator<Integer> it = objects.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void testMap(){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"xiaoli");
        map.put(2,"xiaocheng");
        map.put(3,"xiaozheng");
        //第一种遍历：普遍使用，二次取值
        System.out.println(map.keySet());
        for (int i : map.keySet()){
            System.out.println("key值："+i +" 对应的value:"+map.get(i));
        }

        //第二种
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }
    }




}
