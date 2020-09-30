package com.example.demo.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class VoteEmailServiceImpl{

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String from,String to,String object,String content) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);

            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(object);
            simpleMailMessage.setText(content);
            mailSender.send(simpleMailMessage);
            System.out.println("邮件发送成功");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送邮件失败");
        }

    }
}
