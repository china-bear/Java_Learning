package Samples.clazz;

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

    public static void main(String[] args) {
        // 创建抽奖器对象，指定数据类型
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        String[] strProduct = {"苹果手机","华为手机","扫地机器人","咖啡机"};
        // 给抽奖器填充奖品
        for (int i = 0; i < strProduct.length; i++) {
            stringProductGetter.addProduct(strProduct[i]);
        }
        // 抽奖
        String product1 = stringProductGetter.getProduct();
        System.out.println("恭喜你, 你抽中了：" + product1);

        System.out.println("--------------------------------");

        ProductGetter<Integer> intProductGetter = new ProductGetter<>();
        int[] intProducts = {10000,5000,3000,2000,1000};
        for (int i = 0; i < intProducts.length; i++) {
            intProductGetter.addProduct(intProducts[i]);
        }

        Integer product2 = intProductGetter.getProduct();
        System.out.println("恭喜你, 你抽中了：" + product2);
    }
}
