package com.chinabear.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String url = "jdbc:mysql://10.172.175.xxx:3301/test_db?useUnicode=true&characterEncoding=utf8&useSSL=false";
        // mysql 账号和密码
        String user = "admin";
        String password = "admin@360";
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;

        try {
            //加载驱动程序
            Class.forName(driver);

            conn = DriverManager.getConnection(url,user,password);

            if( !conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            stmt = conn.createStatement();

            // create table
            String drop_sql = "drop table if exists t_student";
            stmt.executeUpdate(drop_sql);


            String create_sql = new StringBuilder()
                    .append("create table t_student (                " )
                    .append("id int unsigned not null auto_increment," )
                    .append("name varchar(32) not null default \"\", " )
                    .append("age int not null,                       " )
                    .append("primary key(id)                         " )
                    .append(") ENGINE=InnoDB  DEFAULT CHARSET=utf8   " )
                    .toString();

            stmt.executeUpdate(create_sql);

            // insert
            String insert_sql = "insert into t_student(id,name, age) values (1,'虚竹', 38),(2,'乔峰', 26),(3,'段誉', 18),(4,'方丈', 52)";

            int insert_rows = stmt.executeUpdate(insert_sql);
            System.out.println("插入记录数：" + insert_rows);

            // update
            String update_sql = "update t_student set age =33  where id =2";
            int update_rows = stmt.executeUpdate(update_sql);
            System.out.println("更新记录数：" + update_rows);

            //delete
            String delete_sql = "delete from t_student where id =3";
            int delete_rows = stmt.executeUpdate(delete_sql);
            System.out.println("删除记录数：" + delete_rows);

            // 预处理
            String psql = "insert into t_student(name, age) values (?, ?)";
            pstmt = conn.prepareStatement(psql);
            // SQL语句占位符设置实际参数
            pstmt.setString(1,"尼姑");
            pstmt.setInt(2,36);
            int prepared_rows = pstmt.executeUpdate();
            System.out.println("预处理方式插入记录数：" + prepared_rows);

            // select
            String sql = "select id, name, age from t_student";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (!stmt.isClosed() || stmt != null)
            stmt.close();
            if ( pstmt !=  null)
                pstmt.close();
            if (!conn.isClosed() || conn != null)
            conn.close();
        }

    }
}
