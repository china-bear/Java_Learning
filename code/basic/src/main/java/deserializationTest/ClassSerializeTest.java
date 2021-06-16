package deserializationTest;

import java.io.*;

/**
 *  https://www.jianshu.com/p/19ba0764bfbd
 *  如果一个类实现了Serializable接口，那么它的子类默认也可以被序列化和反序列化，不论子类是否实现了Serializable接口
 */
public class ClassSerializeTest {

    public static void main(String[] args) throws IOException {

        // 序列化  没有实现Serializable接口的类不能被序列化
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.obj"));
            Person person = new Person("小明", 21, "北京朝阳");

            outputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.obj"));
            Person person = (Person) objectInputStream.readObject();
            // addr 的值为初始值null, 没用序列化到文件中
            System.out.println("name:" + person.getName() + ",age:" + person.getAge() + ",addr:" + person.getAddr());
            // person.staticVar = 10;
            System.out.println(person.staticVar);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    }
}
