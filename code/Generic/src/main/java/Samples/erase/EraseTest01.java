package Samples.erase;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @program: Java_Learning
 * @description: 无限制类型擦除 通过反射泛型，获取参数化类型中 实际的类型
 * @author: Mr.Bear
 * @create: 2020-09-13 11:16
 **/
public class EraseTest01 {

    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();
        System.err.println(intList.getClass().getSimpleName());
        System.err.println(strList.getClass().getSimpleName());

        System.err.println(intList.getClass() == strList.getClass());

        Erasure01<Integer> erasure = new Erasure01<>();
        //利用反射，获取Erasure类的字节码文件的Class类对象
        Class<? extends Erasure01> clz = erasure.getClass();
        //获取所有的成员变量
        Field[] declaredFields = clz.getDeclaredFields();


        for (Field declaredField : declaredFields) {
            //打印成员变量的名称和类型
            System.err.println(declaredField.getName() +":"+ declaredField.getType().getSimpleName());
        }
    }
}

