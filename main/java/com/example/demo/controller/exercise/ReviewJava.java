package com.example.demo.controller.exercise;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewJava {
    public static void main(String[] args) throws IOException {
        //初始化Date对象
        Date dateNow = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间为："+simpleDateFormat.format(dateNow));

        //先创建bufferReader
//        char c;
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("当输入值为‘q’,退出");
//        do {
//            c = (char) bufferedReader.read();
//            System.out.println("输入的值："+c);
//        }while (c != 'q');
        try {
            //向文件中写入和读取数据
            int num[] = {12,24,35};
            //创建输出流
            OutputStream fileInputStream = new FileOutputStream("C:\\Users\\limeng\\Desktop\\aaa.txt");
            for (int i = 0;i < num.length;i++){
                fileInputStream.write(num[i]);
        }
            //关闭输出流
            fileInputStream.close();

            InputStream fileInputStream1 = new FileInputStream("C:\\Users\\limeng\\Desktop\\aaa.txt");
            int available = fileInputStream1.available();

            for (int a = 0; a < available;a++){
                System.out.println("即将输出文本值："+fileInputStream1.read()+" ");
            }
            fileInputStream1.close();
        }catch (IOException e){
            System.out.println("Exception");
        }

    }
}
