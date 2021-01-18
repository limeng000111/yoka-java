package com.example.demo.controller.exercise;

public interface Behaviour {
    void print();
    String getInfo();
}

enum Color1 implements Behaviour {
    RED("红色",1),GREEN("绿色",2);

    private String color;
    private int index;

    Color1(String color, int index) {
        this.color = color;
        this.index = index;
    }


    @Override
    public void print() {
        System.out.println(this.index+":"+this.color);
    }

    @Override
    public String getInfo() {
        return this.name();
    }
}
