package exception;

import javafx.scene.shape.Path;

/**
 * Created by bear on 2020/8/24
 */
public class FinallyReturnTest {

    /* 执行顺序： 执行try块，执行到return语句时，先执行return的语句，--exitValue，但是不返回到main方法，继续执行finally块，
    遇到finally块中的return语句，执行--exitValue,并将值返回到main方法，这里就不会再回去返回try块中计算得到的值，返回值是finally中的return返回的值 */

    public static  int NoException1(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);  // 10
            return  --exitValue;  // 9
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue);
            return --exitValue;
        } finally {
            System.out.println("exitValue in finally block is：" + exitValue); // 9
            return --exitValue;  // 8
        }

    }


    /* 执行顺序：try中执行完return的语句后，不返回，执行finally块，finally块执行结束后，返回到try块中，返回 exitValue 在try块中最后的值。*/
    public static  int NoException2(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);  // 10
            return  --exitValue;   // 9
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue);
            --exitValue;
            System.out.println("exitValue in catch block is：" + exitValue);
            return --exitValue;
        } finally {
            System.out.println("exitValue in finally block from try or catch block is：" + exitValue);  // 9
            --exitValue;
            System.out.println("exitValue in finally block is：" + exitValue);  // 8

            // return --exitValue;
        }

    }

    /* 执行顺序：try中执行完return的语句后，不返回，执行finally块，finally块执行结束后，返回到try块中，返回 exitValue 在try块中最后的值。*/
    public static  int NoException3(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);  // 10
            return  --exitValue;   // 9
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue);
            --exitValue;
            System.out.println("exitValue in catch block is：" + exitValue);
            //return --exitValue;
        } finally {
            System.out.println("exitValue in finally block from try or catch block is：" + exitValue);  // 9
            --exitValue;
            System.out.println("exitValue in finally block is：" + exitValue);  // 8
            // return --exitValue;
        }
        // 后面不会执行，函数 return try 的值
        System.out.println("exitValue in function end block from try or catch block is：" + exitValue);
        --exitValue;
        System.out.println("exitValue in finally block is：" + exitValue);
        return  exitValue;
    }

    /*  执行顺序： 抛出异常后，执行catch块，在catch块的return的--exitValue执行完后，并不直接返回而是执行finally，因finally中有return语句，所以，执行，返回结果6。
    结论：try块中抛出异常，try、catch和finally中都有return语句，返回值是finally中的return */

    public static  int WithException1(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);   // 10
            exitValue = exitValue/0;
            return  --exitValue;
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue); // 10
            --exitValue;
            System.out.println("exitValue in catch block is：" + exitValue);   // 9
            return --exitValue;   // 8
        } finally {
            System.out.println("exitValue in finally from try or catch block is：" + exitValue); // 8
            --exitValue;
            System.out.println("exitValue in finally block is：" + exitValue);   // 7
            return --exitValue;  // 6
        }

    }

/* 执行顺序：抛出异常后，执行catch块，执行完finally语句后，依旧返回catch中的执行return语句后的值，而不是finally中修改的值。*/

    public static  int WithException2(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);   // 10
            exitValue = exitValue/0;
            return  --exitValue;  //  8
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue); // 10
            --exitValue;
            System.out.println("exitValue in catch block is：" + exitValue);   // 9
            return --exitValue;       // 8
        } finally {
            System.out.println("exitValue in finally from try or catch block is：" + exitValue); // 8
            --exitValue;
            System.out.println("exitValue in finally block is：" + exitValue);   // 7
            //return --exitValue;
        }

    }

  /*  执行顺序：try块中出现异常到catch，catch中出现异常到finally，finally中执行到return语句返回，不检查异常。*/
        public static  int WithException3(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);   // 10
            exitValue = exitValue/0;
            return  --exitValue;
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue); // 10
            exitValue = exitValue/0;  // 抛出异常，执行finally
            --exitValue;
            System.out.println("exitValue in catch block is：" + exitValue);
            return --exitValue;
        } finally {
            System.out.println("exitValue in finally from try or catch block is：" + exitValue); // 10
            --exitValue;
            System.out.println("exitValue in finally block is：" + exitValue);   // 9
            return --exitValue;  // 8
        }

    }

    // 只在函数最后return语句返回值
    public static  int WithException4(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);   // 10
            exitValue = exitValue/0;
            //return  --exitValue;
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue); // 10
            //exitValue = exitValue/0;
            --exitValue;
            System.out.println("exitValue in catch block is：" + exitValue);   // 9
            //return --exitValue;
        } finally {
            System.out.println("exitValue in finally from try or catch block is：" + exitValue); // 9
            --exitValue;
            System.out.println("exitValue in finally block is：" + exitValue);   // 8
            //return --exitValue;
        }
        return  --exitValue;  // 7

    }


    // 只在函数最后return语句返回值
    public static  int WithException5(){

        int exitValue =10;

        try {
            System.out.println("exitValue in try block is：" + exitValue);   // 10
            exitValue = exitValue/0;
            //return  --exitValue;
        } catch (Exception ex) {
            System.out.println("exitValue in catch form try block is：" + exitValue); // 10
            exitValue = exitValue/0;   // 抛出异常，执行finally后函数结束
            --exitValue;
            System.out.println("exitValue in catch block is：" + exitValue);
            //return --exitValue;
        } finally {
            System.out.println("exitValue in finally from try or catch block is：" + exitValue); // 10
            --exitValue;
            System.out.println("exitValue in finally block is：" + exitValue);   // 9
            //return --exitValue;
        }
        return  --exitValue;  // CATCH 抛出异常，return不会执行

    }

    /*
    总体结论：
    结论一：
    return语句并不是函数的最终出口，如果有finally语句，这在return之后还会执行finally（return的值会暂存在栈里面，等待finally执行后再返回）
    结论二：
    finally里面不建议放return语句，根据需要，return语句可以放在try和catch里面和函数的最后，可行的做法有四：
    （1）return语句只在函数最后出现一次。
    （2）return语句仅在try和catch里面都出现。
    （3）return语句仅在try和函数的最后都出现。
    （4）return语句仅在catch和函数的最后都出现。 其它情况提示不能Return值 */


    public static void main(String[] args) {

        // try块中没有抛出异常，try、catch和finally块中都有return语句，返回值是finally中的return返回的值
        System.out.println("=============NoException1==================");
        System.out.println("Exit Value: " + NoException1());  // 8
        System.out.println("===========================================");

        // try块中没有抛出异常，仅try和catch中有return语句，返回值是try中的return返回的值
        System.out.println();
        System.out.println("=============NoException2==================");
        System.out.println("Exit Value: " + NoException2());  // 9
        System.out.println("===========================================");

        // try块中没有抛出异常，仅try和catch中有return语句，返回值是try中的return返回的值
        System.out.println();
        System.out.println("=============NoException3==================");
        System.out.println("Exit Value: " + NoException3());  //
        System.out.println("===========================================");


        // try块中有抛出异常，try、catch和finally块中都有return语句，返回值是finally中的return返回的值
        System.out.println();
        System.out.println("=============WithException1==================");
        System.out.println("Exit Value: " + WithException1());  // 6
        System.out.println("===========================================");


        // try块中有抛出异常，仅try和catch中有return语句，，返回值是try中的return返回的值
        System.out.println();
        System.out.println("=============WithException2==================");
        System.out.println("Exit Value: " + WithException2());  // 8
        System.out.println("===========================================");

        // try 和 catch 块中都有抛出异常，try、catch和finally块中都有return语句，返回值是finally中的return返回的值
        System.out.println();
        System.out.println("=============WithException3==================");
        System.out.println("Exit Value: " + WithException3());  // 8
        System.out.println("===========================================");

        // 仅try块中有抛出异常，只在函数最后return语句返回值， 返回值是函数最后return返回的值
        System.out.println();
        System.out.println("=============WithException4==================");
        System.out.println("Exit Value: " + WithException4());  // 7
        System.out.println("===========================================");

        // try 和 catch 块中都有抛出异常，只在函数最后return语句返回值, 结果抛出异常
        System.out.println();
        System.out.println("=============WithException5==================");
        System.out.println("Exit Value: " + WithException5());  // 抛出异常，不能还回 exitValue
        System.out.println("===========================================");

    }
}
