package linear_data_structure.object_copier;

import java.io.Serializable;

/**
 * 对象实现序列化接口实现深拷贝
 * Created by bear on 2020/9/14
 */
public class Teacher03 implements Serializable {
    // serialVersionUID 是 Java 为每个序列化类产生的版本标识，可用来保证在反序列时，发送方发送的和接受方接收的是可兼容的对象,其实就是验证对象版本一致性
    private static final long serialVersionUID = 1L;

    //老师姓名
    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

