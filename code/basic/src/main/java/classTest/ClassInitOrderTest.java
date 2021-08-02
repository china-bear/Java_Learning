package classTest;

import java.util.Scanner;

public class ClassInitOrderTest {

    //	static{
//		System.out.println("Test---静态代码块！");
//	}
    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字：");
		int key = sc.nextInt(); // 读取数字

		switch (key) {
            case 0:
                ClassInitOrderParent parent=new ClassInitOrderParent();
                break;
/**			Parent---执行静态代码块了1！
    		Parent---执行静态代码块了2！
    		Parent---执行非静态代码块了1！
    		Parent---执行非静态代码块了2！
    		Parent---无参构造函数！
 */
            // 说明：先加载静态代码块，后加载非静态代码块
            case 1:
                ClassInitOrderChild b= new ClassInitOrderChild();
                break;
/**			Parent---执行静态代码块了1！
    		Parent---执行静态代码块了2！
    		Child---执行静态代码块了1！
    		Child---执行静态代码块了2！
    		Parent---执行非静态代码块了1！
    		Parent---执行非静态代码块了2！
    		Parent---无参构造函数！
    		Child---执行非静态代码块了1！
    		Child---执行非静态代码块了2！
    		Child---无参构造函数！
 */
            //说明：创建子类，会先执行父类，先执行父类静态——>子类静态——>父类非静态——>父类构造——>子类非静态——>子类构造
            case 2:
                ClassInitOrderChild c= new ClassInitOrderChild(4);
                //这个构造函数中指明了调用父类的有参构造函数，若不指定，则调用父类无参构造函数
                break;
/**			Parent---执行静态代码块了1！
			Parent---执行静态代码块了2！
			Child---执行静态代码块了1！
			Child---执行静态代码块了2！
			Parent---执行非静态代码块了1！
			Parent---执行非静态代码块了2！
			Parent---有参构造函数！
			Child---执行非静态代码块了1！
			Child---执行非静态代码块了2！
			Child---有参构造函数！
 */
            //说明：静态代码块或非静态代码块执行顺序，按照代码前后编写顺序。
            case 3:
                ClassInitOrderChild d= new ClassInitOrderChild();
                ClassInitOrderChild e= new ClassInitOrderChild(4);
                break;
/**			Parent---执行静态代码块了1！
			Parent---执行静态代码块了2！
			Child---执行静态代码块了1！
			Child---执行静态代码块了2！
			Parent---执行非静态代码块了1！
			Parent---执行非静态代码块了2！
			Parent---无参构造函数！
			Child---执行非静态代码块了1！
			Child---执行非静态代码块了2！
			Child---无参构造函数！
			Parent---执行非静态代码块了1！
			Parent---执行非静态代码块了2！
			Parent---有参构造函数！
			Child---执行非静态代码块了1！
			Child---执行非静态代码块了2！
    		Child---有参构造函数！
 */
            //说明：创建多个子类，但父类静态代码块只执行一次。
            case 4:
                ClassInitOrderChild.staticChildMethod(4);
                break;
/**			Parent---执行静态代码块了1！
            Parent---执行静态代码块了2！
            Child---执行静态代码块了1！
            Child---执行静态代码块了2！
            Child---静态方法/staticChildNum=4
 */
            // 说明：静态方法只可以调用静态变量。
            case 5:
                ClassInitOrderChild.staticParentMethod(5);
                break;
/**			Parent---执行静态代码块了1！
			Parent---执行静态代码块了2！
			Parent---静态方法/staticParentNum=5
 */
            //说明：静态方法可通过 父类名.静态方法() 调用。
            case 6:
                System.out.println("父类的静态变量值staticParentNum="+ClassInitOrderParent.staticParentNum);
                break;
/**			Parent---执行静态代码块了1！
			Parent---执行静态代码块了2！
			父类的静态变量值staticParentNum=0
 */
            // 说明：调用静态变量时，静态代码块会执行。
            case 7:
                System.out.println("子类的静态变量值staticChildNum="+ClassInitOrderChild.staticChildNum);
                break;
/**			Parent---执行静态代码块了1！
    		Parent---执行静态代码块了2！
    		Child---执行静态代码块了1！
    		Child---执行静态代码块了2！
    		子类的静态变量值staticChildNum=0
 */
            //说明：调用子类静态变量，父类静态代码块和子类静态代码块会被执行。
            case 8:
                System.out.println("父类的静态变量值staticParentNum="+ClassInitOrderParent.staticParentNum);
                System.out.println("子类的静态变量值staticChildNum="+ClassInitOrderChild.staticChildNum);
                break;

 /**		Parent---执行静态代码块了1！
			Parent---执行静态代码块了2！
			父类的静态变量值staticParentNum=0
			Child---执行静态代码块了1！
			Child---执行静态代码块了2！
			子类的静态变量值staticChildNum=0
  */
            case 9:
                ClassInitOrderChild f= new ClassInitOrderChild();
                f.ParentMethod(3);
                break;
/**			Parent---执行静态代码块了1！
			Parent---执行静态代码块了2！
			Child---执行静态代码块了1！
			Child---执行静态代码块了2！
			Parent---执行非静态代码块了1！
			Parent---执行非静态代码块了2！
			Parent---无参构造函数！
			Child---执行非静态代码块了1！
			Child---执行非静态代码块了2！
			Child---无参构造函数！
			Parent---非静态方法/parentNum=3
 */
            //说明：创建子类，用子类调用父类方法，非静态方法可以调用静态变量。

            default:
                break;
        }

    }

}
