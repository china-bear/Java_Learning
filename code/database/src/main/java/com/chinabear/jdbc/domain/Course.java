package com.chinabear.jdbc.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: Course
 * @author: Mr.Bear
 * @create: 2020-12-27 19:58
 **/
public class Course {

    private Integer id;
    private String name;
    private List<Student> studentList = new ArrayList<Student>();//关联属性
    public Course(){}
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
    public List<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
