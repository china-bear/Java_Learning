package classTest;

import java.util.Scanner;

/**
 * @program: Java_Learning
 * @description: 测试类封装
 * @author: Mr.Bear
 * @create: 2021-02-28 10:33
 **/
public class EncapsulationTest02 {

    String name;
    int age;

    public EncapsulationTest02() {
        System.out.println("无参构造方法");
    }

    public EncapsulationTest02(String name, int age) {
        this();  //必须构造方法中的第一条语句
        System.out.println("有参构造方法");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0 && age <150) {
            this.age = age;
        } else {
            System.out.println("数据错误：恢复默认值：18岁");
            this.age = 18;
        }

    }

    public void print() {
        System.out.println("\t\t\t会员信息\n姓名：" + name + ", 年龄：" + age + "!");
    }

    public static void main(String[] args) {
        EncapsulationTest02 p = new EncapsulationTest02("10001", 100);
        System.out.println("=======================================");
        EncapsulationTest02 person = new EncapsulationTest02();
        System.out.println("=======================================");

        System.out.println("\t\t\t输入会员信息");
        Scanner input = new Scanner(System.in);
        System.out.print("请输入姓名：");
        person.setName(input.next());
        System.out.print("请输入年龄：");
        person.setAge(input.nextInt());

        person.print();
    }
}
