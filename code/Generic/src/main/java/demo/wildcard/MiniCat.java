package demo.wildcard;

/**
 * @program: Java_Learning
 * @description: MiniCat
 * @author: Mr.Bear
 * @create: 2020-09-13 10:30
 **/
public class MiniCat extends Cat {

    public int level;

    public MiniCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "level=" + level +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
