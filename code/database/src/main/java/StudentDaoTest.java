import com.chinabear.jdbc.domain.Course;
import com.chinabear.jdbc.domain.Students;
import com.chinabear.jdbc.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: https://juejin.cn/post/6844903574971875342
 * @description: studentDaoTest
 * @author: Mr.Bear
 * @create: 2020-12-27 18:28
 **/
public class StudentDaoTest {

    //一对一
    public Students findById(int id) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{

            return sqlSession.selectOne("studentsNamespace.findById", id);

            /*  sqlSession.commit();*/
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    //一对多
    public List<Students> findByGrade(String grade) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{

            return sqlSession.selectList("studentsNamespace.findByGrade", grade);
            /*  sqlSession.commit();*/
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }

    // 多对多
    /**
     * 查询哈哈选学了哪些课程
     * @param name 表示学生的姓名
     */
    public List<Course> findAllByName(String name) throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtil.getSqlSession();
            return sqlSession.selectList("courseNamespace.findAllByName",name);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }
    /**
     * 查询java课程有哪些学生选修
     * @param name 表示学生的课程
     */
    public List<Students> findAllByCourseName(String name) throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtil.getSqlSession();
            return sqlSession.selectList("studentsNamespace.findAllByCourseName",name);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }


    public static void main(String[] args) throws Exception {
        //一对一
        StudentDaoTest studentDaoTest = new StudentDaoTest();
        Students students = studentDaoTest.findById(1);
        System.out.println(students.getId() + "----" + students.getName() + "----" + students.getCard().getNum());
        //一对多
        List<Students> students2 = studentDaoTest.findByGrade("一年级");
        for (Students student1 : students2) {
            System.out.println(student1.getName());
        }

        //多对多
        List<Course> courseList = studentDaoTest.findAllByName("孙悟空");
        System.out.print("孙悟空学了" + courseList.size()+"个课程,分别是：");
        for(Course c : courseList){
            System.out.print(c.getName()+" ");
        }
        System.out.println("\n-----------------------------------------------------");
        List<Students> studentList = studentDaoTest.findAllByCourseName("android");
        System.out.println("选修了android课程的学生有"+studentList.size()+"个，分别是：");
        for(Students s : studentList){
            System.out.print(s.getName()+" ");
        }
    }
}
