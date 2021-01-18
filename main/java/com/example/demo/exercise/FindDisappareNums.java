package com.example.demo.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDisappareNums {
    @Test
    public void findDisappearNumbers(){
        int[] nums = {2,34,6,8,9,6,4,3};
        //数组的长度为hashmap的key，初始默认为true
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0;i <nums.length;i++){
            hm.put(nums[i],true);
        }
        //result列表用来存储不存在的数值
        List<Integer> result = new ArrayList<>();
        for (int i = 1;i <= nums.length;i++){
            if (!hm.containsKey(i)){
                result.add(i);
            }
        }
        System.out.println(result);
    }
}
