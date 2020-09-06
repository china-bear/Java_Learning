package demo.history;

import java.util.ArrayList;

/**
 * @program: Java_Learning
 * @description: 泛型产出的背景
 * @author: Mr.Bear
 * @create: 2020-09-05 17:16
 **/
public class MainClass {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Java");
        list.add(100);
        list.add(true);

        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            String str = (String) o;  // 运行出现：ClassCastException 错误
            System.out.println(str);
        }

        // 泛型
        // 编译期间检查类型
        // 减少数据类型转换
        ArrayList<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");

        for (int i = 0; i < strList.size(); i++) {
            String s = strList.get(i);
            System.out.println(s);

        }

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);
        intList.add(200);
        intList.add(300);

        for (int i = 0; i < intList.size(); i++) {
            Integer num = intList.get(i);
            System.out.println(num);

        }


    }
}
