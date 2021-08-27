package object_copier;

/**
 * 对象实现 Cloneable 接口方式实现深拷贝,引用对象也实现 Cloneable 接口
 * Created by bear on 2020/9/14
 */
public class ObjCopyTest04 {

    public static void main(String[] args) throws CloneNotSupportedException {

        //user1有一个teacher对象的属性
        Teacher04 teacher=new Teacher04();
        teacher.setTeacherName("我是teacher一号");
        User04 user1 = new User04();
        user1.setName("我是user一号");
        user1.setTeacher(teacher);

        //对user1进行浅拷贝，再重新赋值其属性
        User04 user2 = (User04)user1.clone();
        user2.setName("我是user二号");
        user2.getTeacher().setTeacherName("我是teacher二号");

        // 进行深拷贝后，改变User2对象中的属性不会对原来User1对象中的属性有任何影响，说明User1和User2 不管是属性还是其引用对象都是重新生成互不关联的两个对象：
        System.out.println("user1 的name"+user1.getName());
        System.out.println("user1 的techerName"+user1.getTeacher().getTeacherName());


        //判断USER1 和 USER2 对象是否是同一个对象
        System.out.println("user1 和 user2 是同一个对象: " + (user1 == user2));
    }
}
