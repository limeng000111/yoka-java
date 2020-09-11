package com.example.demo.User;

import java.io.Serializable;

public class MailBean implements Serializable {
    private static final long serializable = -2231231231231231L;
    private String[] recipient;//收件人
    private String subject;//邮件主题
    private String content;//邮件内容

    public String[] getRecipient() {
        return recipient;
    }

    public void setRecipient(String[] recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
