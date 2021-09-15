package pet.dispatch.sd;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 所谓双分派技术就是在选择一个方法的时候, 不仅仅要根据消息接收者(receiver)的运行时区别, 还要根据参数的运行时区别
 * @Author:
 */
class AnimalDS {
    public void accept(Execute exe) {
        exe.execute(this);
    }
}

class Dog extends AnimalDS {
    public void accept(Execute exe) {
        exe.execute(this);
    }
}

class Cat extends AnimalDS {
    public void accept(Execute exe) {
        exe.execute(this);
    }
}

class Execute {
    public void execute(AnimalDS a) {
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
     * 双分派实现动态绑定的本质就是在重载方法委派的前面加上了继承体系中覆盖的环节, 由于覆盖是动态的, 所以重载就是动态的了
     * 结果:
     * Animal
     * Dog
     * Cat
     */
    public static void main(String[] args) {
        AnimalDS a = new AnimalDS();
        AnimalDS d = new Dog();
        AnimalDS c = new Cat();

        Execute exe = new Execute();

        a.accept(exe);
        d.accept(exe);
        c.accept(exe);
    }
}