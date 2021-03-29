package deserializationTest;

import java.io.*;

/**
 *https://www.jianshu.com/p/19ba0764bfbd
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        // 序列化

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
