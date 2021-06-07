package classTest;

import java.util.Arrays;
import java.util.List;

/**
 * 项目初始化
 * https://juejin.cn/post/6844903965163798536
 * https://zhuanlan.zhihu.com/p/90815478
 */
public class LambdaTest {


    public static void main(String[] args) {
/**
 * 方法引用，双冒号操作 [方法引用]的格式是，类名::方法名。
 * 无参数情况
 * NoParamInterface paramInterface2 = ()-> new HashMap<>(); 可替换为 NoParamInterface paramInterface1 = HashMap::new;
 * 一个参数情况 OneParamInterface oneParamInterface1 = (String string) -> System.out.print(string); 可替换为 OneParamInterface oneParamInterface2 = (System.out::println);
 * 两个参数情况 Comparator c = (Computer c1, Computer c2) -> c1.getAge().compareTo(c2.getAge()); 可替换为  Comparator c = (c1, c2) -> c1.getAge().compareTo(c2.getAge());
 * 进一步可替换为 Comparator c = Comparator.comparing(Computer::getAge);
*/

/** Lambda表达式与匿名类的区别
 *
 * 1. 关键词的区别：对于匿名类，关键词this指向匿名类，而对于Lambda表达式，关键词this指向包围Lambda表达式的类的外部类，也就是说跟表达式外面使用this表达的意思是一样。
 *
 * 2. 编译方式：内部类在编译期生成新类，而Lambda借助invokedynamic指令在运行时动态生成,具有更高的灵活性; Lambda的执行逻辑保留在原类的lambda方法中，内部类则放到新生成的类文件中

 * 3. 所需类型不同 匿名内部类：可以是接口，也可以是抽象类，还可以是具体类。 Lambda表达式：只能是接口
 *
 * 4.使用限制不同 如果接口中有且仅有一个抽象方法，可以使用Lambda表达式，也可以使用匿名内部类。 如果接口中多于一个抽象方法，那么只能使用匿名内部类，而不能使用Lambda表达式。
 *
 * 5. 实现原理不同  匿名内部类编译之后会产生一个单独的.class字节码文件;  Lambda表达式编译之后不会产生一个单独的.class字节码文件。对应的字节码会在运行的时候动态生成。

 */


        /** 1. Runnable线程初始化示例 */
        // 匿名函类写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("欢迎关注公众号：程序新视界");
            }
        }).start();

        // lambda表达式写法
        new Thread(() -> System.out.println("欢迎关注公众号：程序新视界")).start();

        // lambda表达式 如果方法体内有多行代码需要带大括号
        new Thread(() -> {
            System.out.println("欢迎关注公众号");
            System.out.println("程序新视界");
        }).start();

        /** 1.  列表遍历输出示例 */
        List<String> list = Arrays.asList("欢迎","关注","程序新视界");

        // 传统遍历
        for(String str : list){
            System.out.println(str);
        }

        // 使用 -> 的 Lambda 表达式
        list.forEach(n -> System.out.println(n));

        // 使用 :: 的 Lambda 表达式
        list.forEach(System.out::println);

        // 3. 事件处理示例

        // 4. 函数式接口示例

        // 5 .Stream相关示例
        // old way
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7);
        int sum1 = 0;
        for(Integer n : list2) {
            int x = n * n;
            sum1 = sum1 + x;
        }
        System.out.println(sum1);

        // new way
        int sum2 = list2.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
        System.out.println(sum2);

    }

}
