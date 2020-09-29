package Samples.wildcard;

/**
 * @program: Java_Learning
 * @description: Animal
 * @author: Mr.Bear
 * @create: 2020-09-13 10:29
 **/
public class Animal {

    public String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
