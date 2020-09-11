package com.example.demo.service;

public interface MailService {
    //发送简单邮件
    void sendSimpleMail(String to,String subject,String content);
}
