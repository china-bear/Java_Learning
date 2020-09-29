package Samples.interfaces;

/**
 * @program: Java_Learning
 * @description: "泛型接口实现类"
 * 实现类不是泛型类，接口要明确数据类型，如果接口没有指定类型默认就是Object类型
 * @author: Mr.Bear
 * @create: 2020-09-06 11:55
 **/
public class InterfaceGenericImpl implements InterfaceGeneric<String> {


    @Override
    public String getKey() {
        return "Hello InterfaceGeneric";
    }

    public static void main(String[] args) {
        InterfaceGenericImpl interfaceGeneric = new InterfaceGenericImpl();
        System.out.println(interfaceGeneric.getKey());

    }
}
