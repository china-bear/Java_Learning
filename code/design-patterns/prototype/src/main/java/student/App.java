package student;

import java.io.*;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        /**
         * 浅克隆
         * Citation2修改了奖状等级 没有影响 Citation1的奖状等级, 说明Citation2 和 Citation1 对象是独立的。
         * Citation2修改了Student对象属性之后 Citation1的Student对象属性也同时改变了，说明对象的clone方法并不会把其对象中 引用的其它对象 进行拷贝，这也是我们俗称的浅拷贝
         */
        //1. 创建原型对象
        CitationSimpleClone Citation1 = new CitationSimpleClone();
        Citation1.setRank("特等奖");

        //创建张三学生对象
        Student stu1 = new Student();
        stu1.setName("唐僧");

        Citation1.setStu(stu1);

        //2. 克隆奖状对象
        CitationSimpleClone Citation2 = Citation1.clone();
        Citation2.setRank("三等奖");
        Student stu2 = Citation2.getStu();
        stu2.setName("猪八戒");

        //3. 调用show方法展示
        Citation1.show();
        Citation2.show();

        //判断 Citation1对象和 Citation2对象是否是同一个对象
        //System.out.println("是同一个对象?" + (Citation1 == Citation2));

        System.out.println("\n---------------------------------------------\n");

        /**
         * 深克隆
         * Citation2修改了奖状等级 没有影响 Citation1的奖状等级, 说明Citation2 和 Citation1 对象是独立的。
         * Citation2修改了Student对象属性之后 Citation2的Student对象属性没有改变，说明 Citation2 和 Citation1 不管是属性还是其引用对象都是重新生成互不关联的两个对象，这也是我们俗称的深拷贝
         */
        //1，创建对象
        CitationDeepClone Citation3 = new CitationDeepClone();
        Citation3.setRank("一等奖");

        //创建学生对象
        Student stu3 = new Student();
        stu3.setName("孙悟空");

        Citation3.setStu(stu3);

        //创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e:/logs/a.txt"));
        //写对象
        oos.writeObject(Citation3);
        //释放资源
        oos.close();

        //创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e:/logs/a.txt"));
        //读取对象
        CitationDeepClone Citation4 = (CitationDeepClone) ois.readObject();
        //释放资源
        ois.close();

        Citation4.setRank("二等奖");

        Student stu4 = Citation4.getStu();
        stu4.setName("沙僧");

        Citation3.show();
        Citation4.show();

        //判断 Citation3对象和 Citation4对象是否是同一个对象
        //System.out.println("是同一个对象?" + (Citation3 == Citation4));
    }
}

