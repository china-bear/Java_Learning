package pen;

public abstract class Pen {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    abstract void size();
}
