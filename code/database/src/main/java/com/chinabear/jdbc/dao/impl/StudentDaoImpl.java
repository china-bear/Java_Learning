package com.chinabear.jdbc.dao.impl;

import com.chinabear.jdbc.dao.StudentDao;
import com.chinabear.jdbc.domain.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bear on 2020/7/6
 * https://zhuanlan.zhihu.com/p/66290543
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public int insertStudent(Student student) throws ClassNotFoundException, SQLException {
        //驱动程序名称
        String driver = "com.mysql.jdbc.Driver";
        // jdbc url
        String url = "jdbc:mysql://10.172.175.xxx:3301/test_db?useUnicode=true&characterEncoding=utf8&useSSL=false";
        // mysql 账号和密码
        String user = "admin";
        String password = "admin@360";
        // 于一些被重新分配地址的变量或者参数，IDEA默认给它们加上下划线
        Connection conn = null;
        PreparedStatement pstmt = null;

        Class.forName(driver);

        conn = DriverManager.getConnection(url,user,password);

        if( !conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        String sql = "insert into t_student(name,age) values (?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,student.getName());
        pstmt.setInt(2,student.getAge());

        int rs = pstmt.executeUpdate();

        pstmt.close();
        conn.close();

        return rs;
    }

    @Override
    public int updateStudent(Student student) throws ClassNotFoundException, SQLException {
        //驱动程序名称
        String driver = "com.mysql.jdbc.Driver";
        // jdbc url
        String url = "jdbc:mysql://10.172.175.xxx:3301/test_db?useUnicode=true&characterEncoding=utf8&useSSL=false";
        // mysql 账号和密码
        String user = "admin";
        String password = "admin@360";
        // 于一些被重新分配地址的变量或者参数，IDEA默认给它们加上下划线
        Connection conn = null;
        PreparedStatement pstmt = null;

        Class.forName(driver);

        conn = DriverManager.getConnection(url,user,password);

        if( !conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        String sql = "update t_student set name = ?,age = ? where id = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,student.getName());
        pstmt.setInt(2,student.getAge());
        pstmt.setInt(3,student.getId());

        int rs = pstmt.executeUpdate();

        pstmt.close();
        conn.close();

        return rs;
    }

    @Override
    public Student getStudentOne(int id) throws ClassNotFoundException, SQLException {
        //驱动程序名称
        String driver = "com.mysql.jdbc.Driver";
        // jdbc url
        String url = "jdbc:mysql://10.172.175.xxx:3301/test_db?useUnicode=true&characterEncoding=utf8&useSSL=false";
        // mysql 账号和密码
        String user = "admin";
        String password = "admin@360";
        // 于一些被重新分配地址的变量或者参数，IDEA默认给它们加上下划线
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,password);

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

        pstmt.close();
        conn.close();
        return student;
    }

    @Override
    public List<Student> getStudentList() throws ClassNotFoundException, SQLException {
        //驱动程序名称
        String driver = "com.mysql.jdbc.Driver";
        // jdbc url
        String url = "jdbc:mysql://10.172.175.xxx:3301/test_db?useUnicode=true&characterEncoding=utf8&useSSL=false";
        // mysql 账号和密码
        String user = "admin";
        String password = "admin@360";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,password);

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

        pstmt.close();
        conn.close();
        return students;
    }
}
