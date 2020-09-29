package linear_data_structure.object_copier;

/**
 * 对象实现 Cloneable 接口方式实现深拷贝,引用对象也实现 Cloneable 接口
 * Created by bear on 2020/9/14
 */
public class User04 implements Cloneable {
    //年龄
    private int age;
    //姓名
    private String name;
    //老师
    private Teacher04 teacher;


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

    public Teacher04 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher04 teacher) {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        User04 user = (User04)super.clone();
        // 需要将引用对象也克隆一次
        user.teacher = (Teacher04) teacher.clone();
        return user;
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