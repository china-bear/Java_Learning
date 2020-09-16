package demo.recursion;

/**
 * Created by bear on 2020/9/15
 */
public class factorial {

    public static int factorial(int n) {
        if (n >= 1) {
            //递归方法特点一：在方法中调用自己
            return n * factorial(n - 1);
        } else {
            //递归方法特点二：有至少一个出口条件
            return 1;
        }
    }

    public static void main(String[] args) {

        System.out.println("The factorial of 10 is " + factorial(10));
    }
}
