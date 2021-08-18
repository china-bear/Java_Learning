package mask;

/**
 * 工厂抽象模式
 */
public class LowEndMask implements IMask {

    @Override
    public void showMask() {
        System.out.println("我是低端口罩");
    }
}
