package demo.erase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: Java_Learning
 * @description: 类型擦除(有限、方法、桥接)
 * @author: Mr.Bear
 * @create: 2020-09-13 11:16
 **/
public class EraseTest03 {

    public static void main(String[] args) {

        /*
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();
        System.err.println(intList.getClass().getSimpleName());
        System.err.println(strList.getClass().getSimpleName());

        System.err.println(intList.getClass() == strList.getClass());
        */

        Erasure02<Integer> erasure = new Erasure02<>();
        //利用反射，获取Erasure类的字节码文件的Class类对象
        Class<? extends Erasure02> clz = erasure.getClass();
        //获取所有的成员变量
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //打印成员变量的名称和类型
            System.err.println(declaredField.getName() + ":" + declaredField.getType().getSimpleName());
        }

        //获取所有的方法
        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //打印方法名和方法的返回值类型
            System.err.println(declaredMethod.getName() + ":" + declaredMethod.getReturnType().getSimpleName());
        }

        System.err.println("---------------------------------");
        Class<InfoImpl> infoClass = InfoImpl.class;
        Method[] declaredMethods1 = infoClass.getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.err.println(method.getName()+":"+method.getReturnType().getSimpleName());
        }
    }
}

