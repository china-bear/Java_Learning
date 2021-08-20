package pen;

/**
 * 抽象类的具体实现
 */
public class Pencil extends Pen {

    @Override
    void size() {
        color.color();
        System.out.println("size: 10");
    }
}

