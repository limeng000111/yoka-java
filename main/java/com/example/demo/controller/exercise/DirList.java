package com.example.demo.controller.exercise;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        String dir = "C:\\ProgramData\\Intel\\ShaderCache";
        File file = new File(dir);
        if (file.isDirectory()){
            System.out.println("目录："+dir);
            String s[] = file.list();
            for (int i = 0;i < s.length;i++){
                File file1 = new File(dir + "/" + s[i]);
                if (file1.isDirectory()){
                    System.out.println(file1 + "是一个目录");
                }else {
                    System.out.println(file1 + "是一个文件");
                }
            }
        }else {
            System.out.println(file + "不是一个目录");
        }
    }
}
