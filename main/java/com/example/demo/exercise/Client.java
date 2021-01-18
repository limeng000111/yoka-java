package com.example.demo.exercise;
//客户类
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy();
        proxy.setRent(host);
        Rent proxy1 = (Rent) proxy.getProxy();
        proxy1.rent();
    }
}
