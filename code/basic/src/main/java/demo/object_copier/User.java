package demo.object_copier;

/**
 * 浅拷贝只需要被复制类需要实现 Cloneable接口和重写 clone方法
 * Created by bear on 2020/9/14
 */
public class User implements Cloneable {
    //年龄
    private int age;
    //姓名
    private String name;
    //老师
    private Teacher teacher;


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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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