package com.chinabear.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by bear on 2020/6/30
 */
public class MysqlDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //驱动程序名称
        String driver = "com.mysql.jdbc.Driver";
        // jdbc url
        String url = "jdbc:mysql://10.172.175.222:3301/test_db";
        // mysql 账号和密码
        String user = "admin";
        String password = "admin@360";

        //加载驱动程序
        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url,user,password);

        if( !conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");

        Statement stmt = conn.createStatement();

        // insert

        // update

        //delete

        // select
        String sql = "select id, name from user where id = 1 ";

        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            System.out.println(rs.getString("id") + "\t" + rs.getString("name"));
        }

        stmt.close();
        conn.close();

    }
}
