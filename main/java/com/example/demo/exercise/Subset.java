package com.example.demo.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    @Test
    public void subsets(){
        int[] nums = {1,2,3,4,6};
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        System.out.println(res);
        System.out.println(res.size());
    }
}
