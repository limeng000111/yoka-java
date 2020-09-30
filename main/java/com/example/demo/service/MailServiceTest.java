package com.example.demo.service;


import com.example.demo.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    private static Logger log = (Logger) Logger.getLogger(String.valueOf(HelloController.class));
    String to = "2421712196@qq.com";
    String subject = "hello, 这是投票统计邮件";
    String content = "详情请见地址：http://localhost:8080/resultChartLine";

    @Resource
    private MailService mailService;

    @Test
    public void testSendSimpleMail() {
        mailService.sendSimpleMail(to, subject, content);
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String time = df.format(new Date());
        log.info("发送邮件成功:"+time);
    }
}
