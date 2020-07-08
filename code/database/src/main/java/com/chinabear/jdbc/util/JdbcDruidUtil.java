package com.chinabear.jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;

/**
 * Created by bear on 2020/7/7
 * https://zhuanlan.zhihu.com/p/66290543
 */
public class JdbcDruidUtil {

    private  static Properties p = new Properties();
    private  static DataSource dataSource ;

    static {
        try {
            // 获取类加载器
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            // 使用类加载器获取项目 类路径下面的文件
            InputStream inputStream = classLoader.getResourceAsStream("druid.properties");
            // 使用加载配置文件对应的输入流
            p.load(inputStream);

                // 4.创建连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static Connection getConnnect() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("连接数据库失败", e);
        }
    }

}
