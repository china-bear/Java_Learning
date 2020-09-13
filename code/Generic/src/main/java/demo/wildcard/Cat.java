package demo.wildcard;

/**
 * @program: Java_Learning
 * @description: Cat
 * @author: Mr.Bear
 * @create: 2020-09-13 10:29
 **/
public class Cat extends Animal {

    public int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
