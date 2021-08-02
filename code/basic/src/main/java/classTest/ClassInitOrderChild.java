package classTest;

/**
 父类静态变量 > 父类静态初始块 > 子类静态变量 > 子类静态初始块 > 父类成员变量 > 父类非静态初始块 > 父类构造器 > 子类成员变量 > 子类非静态初始块 > 子类构造器
 */
public class ClassInitOrderChild extends ClassInitOrderParent{

    public int childNum = 5;
    public static int staticChildNum = 18;

    {
        System.out.println("Child---执行非静态代码块了1！  parentNum = " + childNum + ";   staticParentNum = " + staticChildNum);
    }

    {
        System.out.println("Child---执行非静态代码块了2！  parentNum = " + childNum + ";   staticParentNum = " + staticChildNum);
    }

    static{
        System.out.println("Child---执行静态代码块了1！  staticParentNum = " +  staticChildNum);
    }

    static{
        System.out.println("Child---执行静态代码块了2！  staticParentNum = " +  staticChildNum);
    }

    public ClassInitOrderChild(){
        super();
        System.out.println("Child---无参构造函数！");
    }

    public ClassInitOrderChild(int childNum){
        super(childNum);
        System.out.println("Child---有参构造函数！");
    }

    public void childMethod(int childNum){
        this.childNum=childNum;
        System.out.println("Child--非静态方法/childNum="+childNum);
    }

    public static void staticChildMethod(int staticChildNum){
        ClassInitOrderChild.staticChildNum=staticChildNum;
        System.out.println("Child---静态方法/staticChildNum="+staticChildNum);
    }


}

