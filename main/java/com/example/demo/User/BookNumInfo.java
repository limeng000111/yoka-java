package com.example.demo.User;


import javax.persistence.*;

@Entity//告诉JPA这是一个实体类
@Table(name="vote_book")
public class BookNumInfo {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键
    private int id;

    @Column(name = "book")
    private String bookName;

    @Column(name = "num")
    private int num;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "img")
    private String img;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BookNumInfo{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", num=" + num +
                ", img='" + img + '\'' +
                '}';
    }

//    @Override
//    public String toString() {
//        return "BookNumInfo{" +
//                "id=" + id +
//                ", bookName='" + bookName + '\'' +
//                ", num=" + num +
//                '}';
//    }
}
