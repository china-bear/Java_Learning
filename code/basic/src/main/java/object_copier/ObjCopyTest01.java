package object_copier;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象引用拷贝
 * Created by bear on 2020/9/14
 */
public class ObjCopyTest01 {

    public static void main(String[] args) {

        // 初始化一个对象
        User user1 = new User();
        user1.setName("我是user1");
        user1.setAge(18);
        // 复制对象
        User user2 = user1;
        // 改变 person1 的属性值
        user2.setAge(15);
        user2.setName("我是user2");

        // 如果User没用重载toString方法 打印就是引用的对象地址
        System.out.println("person对象："+ user1);
        System.out.println("person1对象：" + user2);
        System.out.println(user1==user2);

        // 把user1对象放到一个List里面
        List<User> userList=new ArrayList<User>();
        userList.add(user1);

        //然后创建user3 对象并从List里面拿出user1对象赋值给user3
        User user3= userList.get(0);

        //给user3的属性值
        user3.setAge(69);
        user3.setName("我是user3");
        // 因为user3和user1其实指向的是同一个对象,所以当我们修改user3的属性时其实修改的也是user1这个对象
        System.out.println("——-------------------------------");
        System.out.println("person对象："+ user1);
        System.out.println("person1对象：" + user3);
        System.out.println(user1==user3);
    }
}
