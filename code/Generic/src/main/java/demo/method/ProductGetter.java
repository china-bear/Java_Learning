package demo.method;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: Java_Learning
 * @description: 抽奖器
 * @author: Mr.Bear
 * @create: 2020-09-06 11:10
 * @param <T>
 **/
public class ProductGetter<T> {

    Random random = new Random();
    //奖品
    private T product;

    //奖品池
    ArrayList<T> list = new ArrayList<>();

    //添加奖品
    public void addProduct(T t) {
        list.add(t);
    }

    //抽奖
    public T getProduct(){
        product = list.get(random.nextInt(list.size()));
        return product;
    }

    /**
     * 泛型方法
     * @param  list 参数
     * @param <E> 泛型标识，具体类型由调用方法的时候来指定
     * @return
     **/
    public <E> E getProduct(ArrayList<E> list) {
        return list.get(random.nextInt(list.size()));
    }

    /**
     * 静态的泛型方法，采用多个泛型类型
     * @param t
     * @param e
     * @param k
     * @param <T>
     * @param <E>
     * @param <K>
     */
    public static <T,E,K> void  printType(T t ,E e,K k){
        System.err.println(t+"\t"+t.getClass().getSimpleName());
        System.err.println(e+"\t"+e.getClass().getSimpleName());
        System.err.println(k+"\t"+k.getClass().getSimpleName());
    }

    // 泛型方法与可变参数
    public static <E> void print(E... e){
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }

    public static void main(String[] args) {
        ProductGetter<Integer> productGetter = new ProductGetter<>();
        ArrayList<String> strList = new ArrayList<>();
        strList.add("笔记本电脑");
        strList.add("iphone11");
        strList.add("MacBook");
        //泛型方法的使用，类型是通过调用方法的时候来指定的
        String product = productGetter.getProduct(strList);
        System.err.println(product);

        System.err.println("-----------------------------------------------");

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1000);
        intList.add(2000);
        intList.add(5000);
        Integer product1 = productGetter.getProduct(intList);
        System.err.println(product1);

        System.err.println("-----------------------------------------------");
        //调用多个泛型类型的静态泛型方法
        ProductGetter.printType(100,"java",true);

        //可变参数的泛型方法的调用
        System.err.println("-----------------------------------------------");
        ProductGetter.print(1,2,3,4,5);
        ProductGetter.print("a",3,"name");
    }
}
