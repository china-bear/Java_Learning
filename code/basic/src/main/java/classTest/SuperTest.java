package classTest;

/**
 *  https://segmentfault.com/a/1190000040426685
 *  1、调用父类的构造方法
 *  2、调用父类的成员属性
 *  3、调用父类的方法
 *  除了顶级类 Object.class 构造函数没有调用父类的构造方法, 其余的所有类都默认在构造函数中调用了父类的构造函数（没有显式声明父类的子类其父类是 Object）
 **/

public class SuperTest {

    static public class Teacher {

        public String name;

        public Teacher() {
            System.out.println("我是一名人民教师。");
        }

        public void setName(String name){
            this.name = name;
        }
    }

    static class Student extends Teacher {

        public Student() {
            // 子类默认是通过 super() 调用父类的无参构造方法, 如果父类显示声明了一个有参构造方法, 而没有声明无参构造方法, 实例化子类是会报错的
            super();  //1. 调用父类的构造方法, 这条代码只能放在构造函数的第一行, 保证父类优先初始化
            System.out.println("我是一名学生。");
        }

        public void fatherName() {
            super.setName("小军"); //2. 调用父类普通方法
            System.out.println("我的父类名字是：" + super.name); // 3. 调用父类的属性
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.fatherName();
    }
}
