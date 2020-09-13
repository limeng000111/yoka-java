package com.example.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@EnableScheduling
public class SendEmailJob {

    @Resource
    private MailService mailService;

    @Scheduled(cron = "0 0 0 0/1 * *")
    public void sendEmail(){
        String to = "2421712196@qq.com";
        String subject = "hello, 这是投票统计邮件";
        String content = "详情请见地址：http://localhost:8080/resultChartLine";
        mailService.sendSimpleMail(to, subject, content);

        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String time = df.format(new Date());
        System.out.println("发送邮件成功:"+time);
    }
}
