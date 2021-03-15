package classTest;

/**
 * @program: Java_Learning
 * @description: 多态 向上转型实现 : 使用父类的作为方法形参实现多态  自动进行类型转换
 * 编写父类
 * 编写子类，子类重写父类的方法
 * 运行时，使用父类的方法，子类的对象
 *
 * @author: Mr.Bear
 * @create: 2021-03-07 23:11
 **/

abstract class Pet {
    int health = 60;
    public abstract void eat();
}

class Dog extends Pet {

    @Override
    public void eat() {
        System.out.print("啃骨头！");
        health += 5;
        System.out.println("健康值 = " + health);
    }
}

class Cat extends Pet {

    @Override
    public void eat() {
        System.out.print("吃鱼！");
        health += 15;
        System.out.println("健康值 = " + health);
    }
}

class Panda extends Pet {

    @Override
    public void eat() {
        System.out.print("吃竹子！");
        health += 10;
        System.out.println("健康值 = " + health);
    }
}

class Master {
    //使用父类的作为方法形参实现多态
    public void feed (Pet p) {
        p.eat();
    }
}
public class PolymorphismTest02 {
    public static void main(String[] args) {
        Master master = new Master();
        Pet pet = new Dog();  //向上转型，自动类型转换，父类引用指向子类
        master.feed(pet);
        master.feed(new Cat());
        master.feed(new Panda());
    }

}
