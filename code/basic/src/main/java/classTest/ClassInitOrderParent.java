package classTest;
/**
单类的初始化顺序为:  静态变量 > 静态初始块 > 成员变量 > 非静态初始块 > 构造器
*/
public class ClassInitOrderParent {
    public int parentNum=10;
    public static int staticParentNum=999;

    {
        System.out.println("Parent---执行非静态代码块了1！  parentNum = " + parentNum + ";   staticParentNum = " + staticParentNum);
    }

    {
        System.out.println("Parent---执行非静态代码块了2！  parentNum = " + parentNum + ";   staticParentNum = " + staticParentNum);
    }

    static{
        System.out.println("Parent---执行静态代码块了1！  staticParentNum = " +  staticParentNum);
    }

    static{
        System.out.println("Parent---执行静态代码块了2！  staticParentNum = " +  staticParentNum);
    }

    public ClassInitOrderParent(){
        System.out.println("Parent---无参构造函数！");
    }
    public ClassInitOrderParent(int parentNum){
        this.parentNum=parentNum;
        System.out.println("Parent---有参构造函数！");

    }

    public void ParentMethod(int parentNum){
        this.parentNum=parentNum;
        System.out.println("Parent---非静态方法/parentNum="+parentNum);
    }

    public static void staticParentMethod(int staticParentNum){
        ClassInitOrderParent.staticParentNum=staticParentNum;
        System.out.println("Parent---静态方法/staticParentNum="+staticParentNum);
    }

}

