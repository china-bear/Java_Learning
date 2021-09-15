package pet.dispatch.d;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 通过方法的重写支持动态分派
 * @Author:
 */
class Animal {
    public void execute() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {
    @Override
    public void execute() {
        System.out.println("Dog");
    }
}

class Cat extends Animal {
    @Override
    public void execute() {
        System.out.println("Cat");
    }
}

class Client {

    /**
     * 通过方法的重写支持动态分派, 就是多态
     * Java编译器在编译时期并不总是知道哪些代码会被执行, 因为编译器仅仅知道对象的静态类型, 而不知道对象的真实类型, 而方法的调用则是根据对象的真实类型，而不是静态类型
     * 结果:
     * Dog
     * Cat
     */
    public static void main(String[] args) {
        Animal a = new Dog();
        a.execute();

        Animal c = new Cat();
        c.execute();
    }
}