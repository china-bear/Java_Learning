package classTest;

/**
 * @program: Java_Learning
 * @description: 多态测试
 * @author: Mr.Bear
 * @create: 2021-02-28 21:01
 **/

/**
 * 多态：同一个引用类型，使用不同的实类而执行不同的操作：指同一操作作用不同的对象，可以有不同的解释，产出不同的执行结果
多态存在的三个必要条件
 1.要有继承
 2.要有重写
 3.父类引用指向子类对象

 本质上多态分两种：
 编译时多态（又称静态多态）  重载（overload）就是编译时多态的一个例子，编译时多态在编译时就已经确定，运行时运行的时候调用的是确定的方法。
 运行时多态（又称动态多态）  常所说的多态指的都是运行时多态，也就是编译时不确定究竟调用哪个具体方法，是指在执行期间判断所引用对象的实际类型，根据其实际的类型调用其相应的方法。

 多态通常有两种实现方法：
 子类继承父类(extends)
 类实现接口(implements)
 **/

/**
 * https://zhuanlan.zhihu.com/p/50190390
 * 支付抽象类或者接口
 */
abstract class Pay {
    abstract public String pay();
}
/**
 * 支付宝支付
 */
class AliPay extends Pay {
    @Override
    public String pay() {
        System.out.println("支付宝pay");
        return "success";
    }
}
/**
 * 微信支付
 */
class WeixinPay extends Pay {
    @Override
    public String pay() {
        System.out.println("微信Pay");
        return "success";
    }
}
/**
 * 银联支付
 */
class YinlianPay extends Pay {
    @Override
    public String pay() {
        System.out.println("银联支付");
        return "success";
    }
}



public class PolymorphismTest {
    public static void main(String[] args) {
        /**
         * 测试支付宝支付多态应用
         */
        Pay pay = new AliPay();
        pay.pay();
        /**
         * 测试微信支付多态应用
         */
        pay = new WeixinPay();
        pay.pay();
        /**
         * 测试银联支付多态应用
         */
        pay = new YinlianPay();
        pay.pay();
    }

}
