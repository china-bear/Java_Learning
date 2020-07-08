package com.chinabear.jdbc;


import com.chinabear.jdbc.dao.impl.StudentDaoImpl;
import com.chinabear.jdbc.domain.Student;

import java.sql.SQLException;

/**
 * Created by bear on 2020/7/6
 */
public class MysqlClassDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        // insert one
        Student student = new Student("小乔",18);
        System.out.println("插入记录数：" + studentDaoImpl.insertStudent(student));
        // update one
        System.out.println("更新记录数：" + studentDaoImpl.updateStudent(new Student(4,"变化了",68)));
        // select one
        System.out.println(studentDaoImpl.getStudentOne(2).toString());
        // select all
        System.out.println(studentDaoImpl.getStudentList().toString());

    }

}
