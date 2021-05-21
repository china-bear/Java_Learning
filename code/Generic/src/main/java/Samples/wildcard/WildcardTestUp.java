package Samples.wildcard;

import java.util.ArrayList;

/**
 * @program: Java_Learning
 * @description: 泛型上限通配符
 * @author: Mr.Bear
 * @create: 2020-09-13 10:32
 **/
public class WildcardTestUp {

    public static void main(String[] args) {
        ArrayList<Animal>  animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();

        //cats.addAll(animals);
        cats.addAll(cats);
        cats.addAll(miniCats);

        //showAnimal(animals);
        showAnimal(cats);
        showAnimal(miniCats);

    }

    /** ? 代替具体的类型实参,不是类型形参
     * 泛型上限通配符，传递的集合类型，只能是Cat或Cat的子类类型
     * @param list
     */
    public static void showAnimal(ArrayList<? extends Cat> list) {
        // 上限通配符集合不能添加元素，泛型不知道传什么类型进来
        //list.add(new Animal());
        //list.add(new Cat());
        //list.add(new MiniCat());
        for (int i = 0; i < list.size(); i++) {
            Cat cat = list.get(i);
            System.out.println(cat);
        }
    }

}
