package demo.object_copier;

import java.io.Serializable;

/**
 * 对象实现序列化接口实现深拷贝
 * Created by bear on 2020/9/14
 */
public class User03 implements Serializable {

    private static final long serialVersionUID = 1L;

    //年龄
    private int age;
    //姓名
    private String name;
    //老师
    private Teacher03 teacher;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher03 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher03 teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
