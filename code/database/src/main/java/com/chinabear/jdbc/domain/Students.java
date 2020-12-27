package com.chinabear.jdbc.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: Students
 * @author: Mr.Bear
 * @create: 2020-12-27 18:11
 **/
public class Students {

    private Integer id;
    private String name;
    private Card card;//关联属性
    private Grade grade;//关联属性
    private List<Course> courseList = new ArrayList<Course>();//关联属性

    public Students(){}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
