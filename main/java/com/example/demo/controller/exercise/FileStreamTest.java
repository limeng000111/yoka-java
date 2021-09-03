package com.example.demo.controller.exercise;

import org.junit.Test;

import java.io.*;

public class FileStreamTest {
    @Test
    public void readAndWrite() throws IOException {
        File f = new File("a.txt");
        //构建FileOutputStream对象，文件不存在会自动新建
        FileOutputStream fop = new FileOutputStream(f);
        //构建OutputStreamWriter对象，参数可以指定编码
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append("中文输入");
        writer.append("\r\n");
        writer.append("English");
        //关闭写入流
        writer.close();
        //关闭输出流
        fop.close();

        FileInputStream fip = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()){
            //转成char加到StringBuffer中
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
        fip.close();

    }
}
