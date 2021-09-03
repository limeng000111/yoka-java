package com.example.demo.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12,2,45,56,3,34,56,33,543};
        quick(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quick(int[] arr,int start,int end){
        if (start < end){
            int base = arr[start];
            int low = start;
            int high = end;
            while (low < high){
                while (low < high && base <= arr[high]){
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && base >= arr[low]){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = base;
            quick(arr,start,low);
            quick(arr,low+1,end);
        }

    }
}
