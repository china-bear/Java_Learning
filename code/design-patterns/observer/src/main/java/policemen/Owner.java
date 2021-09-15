package policemen;

import java.util.Observable;
import java.util.Observer;

/**
 * @version v1.0
 * @ClassName: Thief
 * @Description:  业主 观察者
 * @Author:
 */

public class Owner implements Observer {

    // Observer 接口是抽象观察者, 它监视目标对象的变化, 当目标对象发生变化时, 观察者得到通知, 调用 update 方法进行相应的工作

    private String name;

    public Owner(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("业主：" + ((Thief) o).getName() + ", 我已经盯你很久了, 终于逮到你了！！！");
    }
}
