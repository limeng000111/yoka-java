package com.example.demo.exercise;

public enum Color {
    RED("红色",1),GREEN("绿色",2),BLANK("黑色",3);

    private String name;
    private int index;

    private Color(String name,int index){
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static String ColorName(int index){
        for (Color c : Color.values()){
            if (c.getIndex() == index){
                return c.name;
            }
        }
        return null;
    }
}
