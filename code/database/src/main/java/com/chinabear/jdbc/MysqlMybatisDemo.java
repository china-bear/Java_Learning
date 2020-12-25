package com.chinabear.jdbc;

import com.chinabear.jdbc.domain.Student;
import com.chinabear.jdbc.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://mybatis.org/mybatis-3/zh/dynamic-sql.html
// https://segmentfault.com/a/1190000013661958

public class MysqlMybatisDemo {

    public void add(Student student) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.insert("com.chinabear.jdbc.domain.Student.add", student);
            sqlSession.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            throw ex;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    public Student findById(int id) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            return sqlSession.selectOne("com.chinabear.jdbc.domain.Student.findById",id);
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    public List<Student> findAll() throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            return sqlSession.selectList("com.chinabear.jdbc.domain.Student.findAll");
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    public void delete(int id ) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.delete("com.chinabear.jdbc.domain.Student.delete", id);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    public void update(Student student ) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.update("com.chinabear.jdbc.domain.Student.update", student);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    public List<Student> findPage(int start ,int limit) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL

            /**
             * 由于我们的参数超过了两个，而方法中只有一个Object参数收集
             * 因此我们使用Map集合来装载我们的参数
             */
            Map<String, Object> map = new HashMap();
            map.put("start", start);
            map.put("limit", limit);
            return sqlSession.selectList("com.chinabear.jdbc.domain.Student.findPage", map);
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    public List<Student> findByCondition(String name,int age) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            /**
             * 由于我们的参数超过了两个，而方法中只有一个Object参数收集
             * 因此我们使用Map集合来装载我们的参数
             */
            Map<String, Object> map = new HashMap();
            map.put("name", name);
            map.put("age", age);
            return sqlSession.selectList("com.chinabear.jdbc.domain.Student.findByCondition", map);
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    public static void main(String[] args) throws Exception {

        MysqlMybatisDemo mysqlMybatisDemo = new MysqlMybatisDemo();

        Student student1 = new Student(10, "张三丰", 29);
        mysqlMybatisDemo.add(student1);

        Student student2 = new Student(10, "张八丰", 50);
        mysqlMybatisDemo.update(student2);

        System.out.println("========================");
        List<Student> student4 = mysqlMybatisDemo.findPage(0, 3);
        System.out.println(student4);
        System.out.println("========================");

        Student student3 = mysqlMybatisDemo.findById(10);
        System.out.println(student3);

        mysqlMybatisDemo.delete(10);

        List<Student> students = mysqlMybatisDemo.findAll();
        System.out.println(students.size());
        System.out.println(students);

        List<Student> students2 = mysqlMybatisDemo.findByCondition("小乔",30);
    }
}
