package pet.dispatch.s;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 通过方法重载支持静态分派
 * @Author:
 */
class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

class Execute {
    public void execute(Animal a) {
        System.out.println("Animal");
    }
    public void execute(Dog d) {
        System.out.println("Dog");
    }
    public void execute(Cat c) {
        System.out.println("Cat");
    }
}


class Client {
    /**
     * 重载方法的分派是根据静态类型进行的, 这个分派过程在编译时期就完成了
     * Java编译器在编译时期并不总是知道哪些代码会被执行, 因为编译器仅仅知道对象的静态类型, 而不知道对象的真实类型, 而方法的调用则是根据对象的真实类型，而不是静态类型
     * 结果:
     * Animal
     * Animal
     * Animal
     */
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();
        Animal c= new Cat();

        Execute exe = new Execute();

        exe.execute(a);
        exe.execute(d);
        exe.execute(c);
    }
}