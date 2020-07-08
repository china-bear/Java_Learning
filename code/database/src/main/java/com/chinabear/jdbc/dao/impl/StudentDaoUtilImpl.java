package com.chinabear.jdbc.dao.impl;

import com.chinabear.jdbc.dao.StudentDao;
import com.chinabear.jdbc.domain.Student;
import com.chinabear.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bear on 2020/7/7
 */
public class StudentDaoUtilImpl implements StudentDao {


    @Override
    public int insertStudent(Student student) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn =  JdbcUtil.getConnnect();

        if( !conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        String sql = "insert into t_student(name,age) values (?,?)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,student.getName());
        pstmt.setInt(2,student.getAge());

        int rows = pstmt.executeUpdate();
        JdbcUtil.close(conn,pstmt,rs);
        return rows;
    }

    @Override
    public int updateStudent(Student student) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn =  JdbcUtil.getConnnect();

        if( !conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        String sql = "update t_student set name = ?,age = ? where id = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,student.getName());
        pstmt.setInt(2,student.getAge());
        pstmt.setInt(3,student.getId());

        int rows = pstmt.executeUpdate();
        JdbcUtil.close(conn,pstmt,rs);
        return rows;
    }

    @Override
    public Student getStudentOne(int id) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn =  JdbcUtil.getConnnect();

        if( !conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        String sql = "select *  from t_student where id = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,2);

        rs = pstmt.executeQuery();

        //先使用rs.next() 然后在采用使用rs.getXXX() 等方法取出结果集中的数据   否则 java.sql.SQLException: Before start of result set
        rs.next();

        String name = rs.getString("name");
        int age = rs.getInt("age");
        Student student = new  Student(id, name, age);

        JdbcUtil.close(conn,pstmt,rs);
        return student;
    }

    @Override
    public List<Student> getStudentList() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        conn =  JdbcUtil.getConnnect();

        if( !conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");


        String sql = "select *  from t_student";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while(rs.next()) {
            //通过数据库数据和Java对应的数据类型获取对应的只
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            //System.out.println(id+","+name+","+age);

            //将获取的数据封装成对应的Student对象
            Student student = new  Student(id, name, age);
            //将一个个Student对象添加到list集合中
            students.add(student);
        }

        JdbcUtil.close(conn,pstmt,rs);
        return students;
    }
}
