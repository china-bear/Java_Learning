package classTest;

import java.util.Scanner;

/**
 * @program: Java_Learning
 * @description: 多态 向下转型实现 : 使用父类作为方法返回值类型，结合instanceof 运算符进行强制类型转换
 * 编写父类
 * 编写子类，子类重写父类的方法
 * 运行时，使用父类的方法，子类的对象
 *
 * @author: Mr.Bear
 * @create: 2021-03-07 23:11
 **/

abstract class Pet1 {
    int health = 60;
    int love = 60;
    public abstract void eat();
}

 class Dog1 extends Pet1 {

    @Override
    public void eat() {
        System.out.print("啃骨头！");
        health += 5;
        System.out.println("健康值 = " + health);
    }

    public void playFly() {
        System.out.println("飞盘");
        love +=5;
        System.out.println("亲密度 = " + love);
    }
}

class Cat1 extends Pet1 {

    @Override
    public void eat() {
        System.out.print("吃鱼！");
        health += 15;
        System.out.println("健康值 = " + health);
    }

    public void playBall() {
        System.out.println("飞盘");
        love +=5;
        System.out.println("亲密度 = " + love);
    }
}


class Master1 {
    //使用父类的作为方法形参实现多态
    public Pet1 getPet (String id) {
        switch (id) {
            case "1":
                return new Dog1();
            case "2":
                return new Cat1();
        }
        return null;
    }

    public void play(Pet1 p) {
        if (p instanceof Dog1) {
            Dog1 d = (Dog1)p;
            d.playFly();
        } else {
            Cat1 c = (Cat1)p;
            ((Cat1) p).playBall();
        }

    }
}

public class PolymorphismTest03 {
    public static void main(String[] args) {
        Master1 m = new Master1();
        Scanner input = new Scanner(System.in);
        System.out.print("请选择要领养的宠物：(1.狗狗 2.猫咪)");
        String id = input.next();
        Pet1 p = m.getPet(id); //返回的是虽然是父类类型，实际是子类对象
        p.eat();
        m.play(p);
    }

}
