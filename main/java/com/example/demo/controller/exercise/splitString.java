package com.example.demo.controller.exercise;

import org.junit.Test;

public class splitString {
    @Test
    public String reverseLeftWords(String s,int n) {
        String a = s.substring(n);
        String b = s.substring(0,n-1);
        String target = a + b;
        return target;
    }
}
