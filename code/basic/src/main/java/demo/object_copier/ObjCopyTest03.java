package demo.object_copier;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象实现序列化接口实现深拷贝
 * Created by bear on 2020/9/14
 */
public class ObjCopyTest03 {

    public static void main(String[] args) throws Exception {
        //user1有一个teacher对象的属性
        Teacher03 teacher=new Teacher03();
        teacher.setTeacherName("我是teacher一号");
        User03 user1 = new User03();
        user1.setName("我是user一号");
        user1.setTeacher(teacher);

        //序列化写入到流里
        ByteOutputStream bots=new ByteOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bots);
        oos.writeObject(user1);

        //反序列化成user2对象
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bots.toByteArray()));
        User03 user2 = (User03) ois.readObject();
        user2.setName("我是user二号");
        user2.getTeacher().setTeacherName("我是teacher二号");

        //进行深拷贝后，改变User2对象中的属性不会对原来User1对象中的属性有任何影响，说明User1和User2 不管是属性还是其引用对象都是重新生成互不关联的两个对象：
        System.out.println("user1 的name"+user1.getName());
        System.out.println("user1 的techerName"+user1.getTeacher().getTeacherName());
    }
}
