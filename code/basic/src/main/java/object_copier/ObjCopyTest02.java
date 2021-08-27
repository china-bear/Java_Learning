package object_copier;

/**
 * 对象浅拷贝
 * Created by bear on 2020/9/14
 */
public class ObjCopyTest02 {

    public static void main(String[] args) throws CloneNotSupportedException {

        //user1有一个teacher对象的属性
        Teacher teacher=new Teacher();
        teacher.setTeacherName("我是teacher一号");
        User user1 = new User();
        user1.setName("我是user一号");
        user1.setTeacher(teacher);

        //对user1进行浅拷贝，再重新赋值其属性
        User user2 = (User)user1.clone();
        user2.setName("我是user二号");
        user2.getTeacher().setTeacherName("我是teacher二号");

        //user2修改了name之后并没有影响user1的name,这说明user2和user1对象是独立的。
        System.out.println("user1 的name"+user1.getName());

        //user2修改了teacher 对象属性之后user1的teacher对象属性也同时改变了，这说明对象的clone方法并不会把其对象中引用的其他对象进行拷贝，这也是我们俗称的浅拷贝
        System.out.println("user1 的techerName"+user1.getTeacher().getTeacherName());

        //判断USER1 和 USER2 对象是否是同一个对象
        System.out.println("user1 和 user2 是同一个对象? " + (user1 == user2));
    }
}
