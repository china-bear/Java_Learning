package demo.reflect.GetClassInformatio;

import demo.reflect.Son;
import demo.utils.ClassUtil;

/**
 * Java 三种方式获取 Class 对象, 何一个类都是Class的实例对象
 * Created by bear on 2020/9/4
 */
public class getClassInfoDemo {

    public static void main(String[] args) {


        // 第一种表示方式, 知道具体类的情况下可以使用, 通过T.class
        Class sonClass1 = Son.class;

        // 第二种表示方式， 不知道具体类的情况，通过 Class.forName()传入类的路径获取：
        Class sonClass2 = null;
        try {
            sonClass2 = Class.forName("demo.reflect.Son") ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       /**  第三种表示方式 ，通过对象实例instance.getClass()获取
         * 不仅表示类的类类型，还代表了动态加载类
		 * 编译时刻加载类是静态加载类，运行时刻加载类是动态加载
        */
        Son son = new Son(); // Son son = null;
        Class sonClass3= son.getClass();

        /**
         * 一个类只可能是Class类的一个实例对象，无论采用哪种方式获取返回的都是同一个对象。
         */
        System.out.println(sonClass1 == sonClass2);

        System.out.println(sonClass1 == sonClass3);

        try {
            // 通过类的Class对象创建该类的实例对象
            Son myson = (Son)sonClass1.newInstance(); // 需要有无参的构造方法
            myson.setName("嘟嘟");
            myson.setAge(19);
            myson.printSonMsg();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        ClassUtil.printFieldMsg(son);
        ClassUtil.printConstructorMsg(son);
        ClassUtil.printMethodMsg(son);
    }
}
