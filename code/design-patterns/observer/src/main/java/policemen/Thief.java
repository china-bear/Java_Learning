package policemen;

import java.util.Observable;

/**
 * @version v1.0
 * @ClassName: Thief
 * @Description:  小偷 抽象目标类(被观察者)
 * @Author:
 */
public class Thief extends Observable {

    /**
     * Observable 类是抽象目标类(被观察者),  Vector 集合成员变量用于保存所有要通知的观察者对象, 内置的最重要 3个方法
     * 1. void addObserver(Observer o) 方法：用于将新的观察者对象添加到集合中
     * 2. void notifyObservers(Object arg) 方法：调用集合中的所有观察者对象的 update方法，通知它们数据发生改变。通常越晚加入集合的观察者越先得到通知。
     * 3 .void setChange() 方法：用来设置一个 boolean 类型的内部标志, 注明目标对象发生了变化, 当它为true时, notifyObservers() 才会通知观察者。
     */
    private String name;

    public Thief(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void steal() {
        System.out.println("小偷：我偷东西了，有没有人来抓我！！！");
        super.setChanged(); //changed = true
        super.notifyObservers();
    }
}
