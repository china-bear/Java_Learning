package creational.factory.method_model;

/**
 * Png 图片加载器
 */
public class PngReader implements Reader {

    @Override
    public void read() {
        System.out.println("read png");
    }
}
