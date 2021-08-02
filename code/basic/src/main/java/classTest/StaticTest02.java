package classTest;

/**
* 在new一个对象之前，需要先将类加载到内存中，所以会一直找到最顶层父类Object加载，依次往下加载父类，由于静态代码块是随着类的加载而执行的，所以会先输出“XXX静态代码块”；
* 加载完之后，由于非静态代码的执行顺序是高于构造器方法体内容的，所以，先执行“XXX非静态方法块”后执行“XXX构造器”；
* 在new一个对象时，因为已经加载过了，所以只执行非静态代码块和构造器内容
 **/
public class StaticTest02 {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf();
        System.out.println("****************************");
        Leaf leaf2 = new Leaf();
    }
}

class Root{
    static {
        System.out.println("Root静态代码块");
    }
    {
        System.out.println("Root非静态代码块");
    }
    public Root() {
        System.out.println("Root构造器");
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid静态代码块");
    }
    {
        System.out.println("Mid非静态代码块");
    }
    public Mid() {
        System.out.println("Mid构造器");
    }
}

class Leaf extends Mid{
    static {
        System.out.println("Leaf静态代码块");
    }
    public Leaf() {
        System.out.println("Leaf构造器");
    }
    {
        System.out.println("Leaf非静态代码块");
    }

}