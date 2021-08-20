package pen;

/**
 * 抽象类的具体实现
 */
public class Brush extends Pen {

    @Override
    void size() {
        color.color();
        System.out.println("size: 20");
    }
}

