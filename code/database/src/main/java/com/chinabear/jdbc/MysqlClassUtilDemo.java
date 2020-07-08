package com.chinabear.jdbc;

import com.chinabear.jdbc.dao.impl.StudentDaoUtilImpl;
import com.chinabear.jdbc.domain.Student;

import java.sql.SQLException;

/**
 * Created by bear on 2020/7/6
 */
public class MysqlClassUtilDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        StudentDaoUtilImpl studentDaoUtilImpl = new StudentDaoUtilImpl();
        // insert one
        Student student = new Student("小乔",18);
        System.out.println("插入记录数：" + studentDaoUtilImpl.insertStudent(student));
        // update one
        System.out.println("更新记录数：" + studentDaoUtilImpl.updateStudent(new Student(4,"util生效",78)));
        // select one
        System.out.println(studentDaoUtilImpl.getStudentOne(2).toString());
        // select all
        System.out.println(studentDaoUtilImpl.getStudentList().toString());

    }

}
