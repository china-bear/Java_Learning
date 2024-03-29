package classTest;


public class StudentBuilder {
    private String _name;
    private int _age = 14;      // this has a default
    private String _motto = ""; // most students don't have one

    public StudentBuilder() { }

    public Student buildStudent()
    {
        return new Student(_name, _age, _motto);
    }

    public StudentBuilder name(String _name)
    {
        this._name = _name;
        return this;
    }

    public StudentBuilder age(int _age)
    {
        this._age = _age;
        return this;
    }

    public StudentBuilder motto(String _motto)
    {
        this._motto = _motto;
        return this;
    }

    // https://juejin.cn/post/6844903801510428686   创建工厂模板
/*  为什么要创建一个StudentBuilder  而不是直接这样写： Student s1 = new Student().age(16)
    复制代码这样写有两个坏处: 1. 实例化有些字段没有初始化，可能存在安全隐患
    2 .我们创建一个Student之后，并不希望他有一个.age()方法，这个方法可能会被滥用。*/

    public static void main(String[] args) {
        Student s1 = new StudentBuilder().name("张三丰").buildStudent();
        Student s2 = new StudentBuilder()
                .name("令狐冲")
                .age(16)
                .motto("师傅的女儿")
                .buildStudent();
        System.out.println(s1);
        System.out.println(s2);
    }

 private  class Student {

        public String name;
        public int age;
        // 座右铭
        public String motto;

        public Student(String name, int age, String motto) {
            this.name = name;
            this.age = age;
            this.motto = motto;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", motto='" + motto + '\'' +
                    '}';
        }
    }

}
