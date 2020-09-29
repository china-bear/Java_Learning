package linear_data_structure.object_copier;

/**
 * 对象实现 Cloneable 接口方式实现深拷贝,引用对象也实现 Cloneable 接口
 * Created by bear on 2020/9/14
 */
public class Teacher04 implements Cloneable {

    //老师姓名
    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
