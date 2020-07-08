package com.chinabear.jdbc;

import com.chinabear.jdbc.dao.impl.StudentDaoDruidImpl;
import com.chinabear.jdbc.dao.impl.StudentDaoUtilImpl;
import com.chinabear.jdbc.domain.Student;

import java.sql.SQLException;

/**
 * Created by bear on 2020/7/6
 */
public class MysqlClassDruidDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        StudentDaoDruidImpl studentDaoDruid = new StudentDaoDruidImpl();
        // insert one
        Student student = new Student("大乔",28);
        System.out.println("插入记录数：" + studentDaoDruid.insertStudent(student));
        // update one
        System.out.println("更新记录数：" + studentDaoDruid.updateStudent(new Student(4,"Druid生效",71)));
        // select one
        System.out.println(studentDaoDruid.getStudentOne(2).toString());
        // select all
        System.out.println(studentDaoDruid.getStudentList().toString());

    }

}
