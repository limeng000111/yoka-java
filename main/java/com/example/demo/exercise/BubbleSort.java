package com.example.demo.exercise;

import org.junit.Test;

public class BubbleSort {
    @Test
    public void maopaoSort(){
        int[] arr = {2,5,7,4,76,56,55,5};
        //外层循环，遍历次数
        for (int i = 0; i < arr.length;i++){
            //内层循环,升序，注意i值越大，arr.length-i-1越小
            for (int j = 0; j < arr.length -i -1;j++){
                if (arr[j] > arr[j+1]){
                    //进行数值交换，获取一个最大值，放在最右边
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Test
    public void kuaisuSort(){
        int[] arr1 = {12,34,1,23,3,4,6,4};
        for (int i = 0; i < arr1.length; i++){
            int min = arr1[i];
            int index = i;
            //找到[i+1,arr1.length]的最小值
            for (int j = i + 1;j < arr1.length;j++ ){
                if (min > arr1[j]){
                    min = arr1[j];
                    index = j;
                }
            }
            //将最小值与开始值进行交换
            int temp = arr1[i];
            arr1[i] = arr1[index];
            arr1[index] = temp;
        }
    }
}
