package demo.wildcard;

import java.util.ArrayList;

/**
 * @program: Java_Learning
 * @description: 泛型上限通配符
 * @author: Mr.Bear
 * @create: 2020-09-13 10:32
 **/
public class WildcardTestDown {

    public static void main(String[] args) {
        ArrayList<Animal>  animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();


        showAnimal(animals);
        showAnimal(cats);
        //showAnimal(miniCats);

    }

    /**
     * 泛型下限通配符，传递的集合类型，只能是Cat或Cat的父类类型
     * @param list
     */
    public static void showAnimal(ArrayList<? super Cat> list) {
        // 下限通配符集合可以添加元素（子类类型），但不保证元素数据类型约束要求
        //list.add(new Animal());
        list.add(new Cat("maomao",12));
        list.add(new MiniCat("huahua",5,2));
        // Object 不能接受
        for (Object o : list) {
            System.out.println(o);
        }
    }

}
