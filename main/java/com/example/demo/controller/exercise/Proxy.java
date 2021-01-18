package com.example.demo.controller.exercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;

//代理角色;中介
public class Proxy implements InvocationHandler {
   private Rent rent;

   public void setRent(Rent rent){
       this.rent = rent;
   }

   public Object getProxy(){
       return newProxyInstance(this.getClass().getClassLoader(),
               rent.getClass().getInterfaces(),this);
   }

    //看房
    public void seeHouse(){
        System.out.println("带客看房");
    }

    //收中介费
    public void fare(){
        System.out.println("收取中介费");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        Object result = method.invoke(rent,args);
        fare();
        return result;
    }
}
