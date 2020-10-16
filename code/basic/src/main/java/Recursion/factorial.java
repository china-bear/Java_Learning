package Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归详解
 * 递归2个主要特征,
 * 1. 自身调用：原问题可以分解为子问题，子问题和原问题的求解方法是一致的，即都是调用自身的同一个函数。
 * 2. 终止条件：递归必须有一个终止的条件，即不能无限循环地调用本身
 * https://juejin.im/post/6883259369559965703
 * 看动画轻松理解「递归」与「动态规划」 https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484350&idx=1&sn=fc88aa125f5a5269575b4c4d83774f41&chksm=fa0e6c3fcd79e5297257a05b8c75898b4059b1193956c702ff5ef3f2d8d46432bb7484bf6428&scene=21#wechat_redirect
 */
public class factorial {

    // 求和
    private static int sum(int n) {
        if (n <= 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    // 阶乘
    public static int factorial(int n) {
        //递归方法特点一：递归必须有一个终止的条件,有至少一个出口条件
        if(n==1){
            return 1;
        }
        //递归方法特点二：自身调用：原问题可以分解为子问题，子问题和原问题的求解方法是一致的
        return n * factorial(n-1);
    }

    // 斐波那契数列
    public static int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //经典的青蛙跳阶问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
    // 对于第n阶台阶，考虑到他的前一步，只有两种情况：要么是从第n-1阶过来，要么是从第n-2阶过来，除此外没有其他的来源。
    // 递归解法 时间复杂度为 O(2^n)
    public static int numWays1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return numWays1(n-1) + numWays1(n-2);
    }

    //带备忘录的递归解法 时间复杂度是 O(n)
    static Map<Integer, Integer> tempMap = new HashMap();  //哈希map充当备忘录
    public static int numWays2(int n) {
        // n = 0 也算1种
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        //先判断有没计算过，即看看备忘录有没有
        if (tempMap.containsKey(n)) {
            //备忘录有，即计算过，直接返回
        } else {
            // 备忘录没有，即没有计算过，执行递归计算,并且把结果保存到备忘录map中，对1000000007取余（这个是leetcode题目规定的）
            tempMap.put(n, (numWays2(n - 1) + numWays2(n - 2)) % 1000000007);
        }
        return tempMap.get(n);
    }


    // 动态规划解法 时间复杂度是 O(n)
    public static int numWays3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        // a 保存倒数第二个子状态数据，b 保存倒数第一个子状态数据， temp 保存当前状态的数据
        int a = 1, b = 2;
        int temp = a + b;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }


    public static void main(String[] args) {

        System.out.println("The factorial of 10 is " + factorial(10));
        System.out.println("-----------------------");
        System.out.println(fibonacci(10));
        System.out.println("-----------------------");
        System.out.println(numWays1(10));
        System.out.println(numWays2(10));
        System.out.println(numWays3(10));
        System.out.println("-----------------------");
        // 递归栈溢出测试
        // System.out.println(sum(50000));
    }
}
