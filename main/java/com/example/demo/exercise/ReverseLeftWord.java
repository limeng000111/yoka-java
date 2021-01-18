package com.example.demo.exercise;

import org.junit.Test;

public class ReverseLeftWord {
    @Test
    public void reverseLeftWord(){
        String s = "abcdefg";
        int n = 2;
        String a = s.substring(0,n);
        String b = s.substring(n,s.length());
        String re = b + a;
        System.out.println(re);
    }
}
