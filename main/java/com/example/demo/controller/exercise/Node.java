package com.example.demo.controller.exercise;

import java.util.HashSet;

public class Node {

    //数据域
    public int data;

    //指针域，指向下一个节点
    public Node next;

    public Node(){}

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    /**
     * 增加节点
     */
    public static void addNode(int value, Node head){
        
        //初始化新加入的节点
        Node node = new Node(value);
        
        //设置临时节点
        Node temp = head;

        //找到尾节点
        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
    }

    /**
     * 遍历链表
     */

    public static void traverse(Node head){

        //临时节点，从首节点开始
        Node temp = head.next;

        while (temp != null){
            System.out.println("当前节点的值为："+temp.data);
        }
        temp = temp.next;
    }

    /**
     * 找到链表中倒数第K个节点
     */

    public static Node findNode(Node head, int k){

        //构造测试数据：暂定长度为10
        int linkListLength = 10;

        if (k < 1 && k > linkListLength){
            return null;
        }

        Node p1 = head;

        Node p2 = head;

        //p2比p1快K个节点
        for (int i = 0;i < k-1;i++){
            p2 = p2.next;
        }

        //p2比p1快K个节点，当p2为尾节点，p1就是倒数第k个节点
        while (p2 != null){
            p2.next = p2;
            p1.next = p1;
        }

        return p1;
    }

    public static void HashSetTest(){
        HashSet<Object> objects = new HashSet<>();
    }


}
