package deserializationTest;

import java.io.Serializable;

/**
 * 序列化与反序列化
 * 序列化是将 Java 对象转换成与平台无关的二进制流，二进制流便于保存到磁盘上或者在网络上传输
 * 反序列化则是将二进制流恢复成原来的 Java 对象
 */
public class Person implements Serializable {

    // serialVersionUID是用来验证对象版本一致性的, 强烈建议所有要序列化的类都显示地声明serialVersionUID字段
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    // 静态变量
    public static int staticVar = 5;
    // 阻止变量staticVar被序列化到文件中，在被反序列化后，transient变量的值被设为初始值
    transient private String addr = null;

    public Person() {
    }

    public Person(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getStaticVar() {
        return staticVar;
    }

    public static void setStaticVar(int staticVar) {
        Person.staticVar = staticVar;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
