package classTest;

/**
 *  https://segmentfault.com/a/1190000040426685
 *  1、调用成员变量
 *  2、调用构造方法
 *  3、调用普通方法
 *  4、返回当前对象
 **/

public class ThisTest {

    private String name = "xiaoming";

    private int age;

    public ThisTest() {
        this("小马",50); // 2. this 调用构造方法,  这条代码只能放在构造函数的第一行，这是编译器的规定 ,this为了避免重复初始化
        this.say();   // 3. this 调用普通方法
    }

    public ThisTest(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(name + "今年" + age + "岁了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //name = name;
        this.name = name; // 1. this 调用成员变量
    }

    public void say(){
        System.out.println("小马很会唱歌。");
    }

    public Object newObject() {
        return this;  // 4. 返回当前对象
    }

    // this 和 super 只能一个 出现在同一个构造方法中
    public static void main(String[] args) {
        ThisTest ThisTest1 = new ThisTest();
        ThisTest1.setName("xiaoma");
        System.out.println(ThisTest1.getName());

        ThisTest ThisTest2 = new ThisTest("小军", 45);

        ThisTest ThisTest3 = (ThisTest) ThisTest2.newObject();
        ThisTest3.say();
    }
}
