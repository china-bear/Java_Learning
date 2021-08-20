package pen;

/**
 * 桥接模式
 */
public class App {
    public static void main(String[] args) {
        Pen pencil = new Pencil();
        pencil.setColor(new Red());
        pencil.size();

        Pen brush = new Brush();
        brush.setColor(new Blue());
        brush.size();
    }
}
