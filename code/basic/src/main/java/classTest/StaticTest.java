package classTest;

/**
 * @program: Java_Learning
 * @description: staticTest
 * @author: Mr.Bear
 * @create: 2021-02-28 09:58
 **/
public class StaticTest {

    public StaticTest() {
        System.out.print("默认构造方法！-->");
    }

    //非静态代码块
    {
        System.out.print("非静态代码块！-->");
    }

    //静态代码块  具有最高的优先级
    // 类加载的时候，就被执行了
    static {
        System.out.print("静态代码块！-->");
    }

    private static void test1() {
        System.out.print("静态方法中的内容1! -->");
        {
            System.out.print("静态方法中的代码块！-->");
        }
        System.out.print("静态方法中的内容2! -->");
    }

    private  void test2() {
        System.out.print("方法中的内容1! -->");
        {
            System.out.print("方法中的代码块！-->");
        }
        System.out.print("方法中的内容2! -->");
    }

    public static void main(String[] args) {
        // 类方法 直接调用
        test1();  //静态代码块！-->静态方法中的内容! -->静态方法中的代码块！-->
        System.out.println();System.out.println();
        StaticTest staticTest = new StaticTest();  // 非静态代码块！-->默认构造方法！-->
        System.out.println();System.out.println();
        staticTest.test1();//静态方法中的内容! -->静态方法中的代码块！-->
        System.out.println();System.out.println();
        staticTest.test2();//方法中的内容! -->方法中的代码块！-->
    }
}
