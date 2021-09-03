package com.example.demo.exercise;

import org.junit.Test;

import java.util.ArrayList;

public class MockServer {
    @Test
    public void twoPointSerch(){
        int exp = 12;
        int[] array = new int[]{1,3,12,34,45,56,67};
        int start = 0;
        int finalNum = array.length-1;
        while (start <= finalNum){
            int mid = (start+finalNum)/2;
            if (array[mid] == exp){
                System.out.println("对应值的索引值："+(mid+1));
                break;
            }else if (array[mid] > exp){
                finalNum = mid -1;
            }else {
                start = mid + 1;
            }
        }
        System.out.println("没有找到对应的值");
    }

    @Test
    public void bubble(){
        int[] arrBubb = new int[]{12,354,4,345,34,5,2,42};
        int n = arrBubb.length;
        int a,b;
        for (a = 0;a < n;a++){
            for (b = 1;b < n-a;b++){
                if (arrBubb[b-1] > arrBubb[b]){
                    int temp;
                    temp = arrBubb[b];
                    arrBubb[b] = arrBubb[b-1];
                    arrBubb[b-1] = temp;

                }
            }
        }
        System.out.println("经过排列后的数组："+arrBubb.toString());

    }
}
