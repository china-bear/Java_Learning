package com.chinabear.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by bear on 2020/7/7
 */
public class JdbcUtil {

    private  static Properties p = new Properties();
    static {
        try {
            // 获取类加载器
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            // 使用类加载器获取项目 类路径下面的文件
            InputStream inputStream = classLoader.getResourceAsStream("db.properties");
            // 使用加载配置文件对应的输入流
            p.load(inputStream);
            Class.forName(p.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  static Connection getConnnect() {
        try {
            return DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("连接数据库失败", e);
        }
    }

    public static void  close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        try {
            if(rs !=null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt !=null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(conn !=null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(p.getProperty("url"));
        System.out.println(p.getProperty("username"));
        System.out.println(p.getProperty("password"));
    }

}
