package classTest;

/**
 * @program: Java_Learning
 * @description: 类继承测试
 * @author: Mr.Bear
 * @create: 2021-02-28 11:08
 **/

/**
 * @program: Java_Learning
 * @description: 类继承测试
 * 无条件使用另一个类中的非私有的属性和方法
 *  1 单根性：一个子类只能继承一个父类,anda
 *  2 传递性：A-->B-->C
 *  3 构造方法不能继承
 *  4 子类与父类不在同包，使用默认访问权限的成员和方法不能继承
 * @author: Mr.Bear
 * @create: 2021-02-28 11:10
 **/
class Father {
    public Father() {
        System.out.println("父类构造方法");
    }

    String name;
    int lv;
    int hp;
    int mp;

    void print() {
        System.out.println("父类方法print{}: " + " lv = "  + lv + "  hp = " + hp + "  mp = " + mp);
    }
}

class Computer  extends Father {
    public Computer() {
        System.out.println("子类Computer构造方法");
    }
    String npc;
}

class Person extends Father {
    String id;

    public Person() {
        System.out.println("子类Person构造方法");
    }
}

public class InheritanceTest01 extends Father {

    public static void main(String[] args) {
        // 先调用父类构造方法、在调用子类构造方法
        Person player = new Person();
        player.id = "No001";
        player.lv = 80;
        player.print();

        Computer npc = new Computer();
        npc.npc = "阿基米德";
        npc.mp = 50;
        npc.print();
    }
}
