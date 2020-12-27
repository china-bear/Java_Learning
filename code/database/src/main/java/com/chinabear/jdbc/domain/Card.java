package com.chinabear.jdbc.domain;

/**
 * @program: Java_Learning
 * @description: card
 * @author: Mr.Bear
 * @create: 2020-12-27 17:01
 **/
public class Card {

    private Integer id;
    private String num;
    public Card(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
}
