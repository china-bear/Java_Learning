package reflect.CallClassMethods;

import reflect.Son;

import java.lang.reflect.Field;

/**
 * Created by bear on 2020/9/4
 * 为简洁代码，在方法上抛出总的异常，实际开发别这样
 */
public class modifyFinalFiled {

    public static void main(String[] args)  throws Exception {

        Son son = new Son();

        // 第一步:获取类类型
        Class sonClass = son.getClass();

        //2. 获取私有变量
        Field finalField1 = sonClass.getDeclaredField("FINAL_VALUE1");
        Field finalField2 = sonClass.getDeclaredField("FINAL_VALUE2");

        //3. 修改常量的值
        if (finalField1 != null) {

            //获取私有常量的访问权
            finalField1.setAccessible(true);

            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改前的值
            System.out.println("Before Modify：FINAL_VALUE = "
                    + finalField1.get(son));

            //修改私有常量
            finalField1.set(son, "Modified");

            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改后的值
            System.out.println("After Modify：FINAL_VALUE = "
                    + finalField1.get(son));

            //使用对象调用类的 getter 方法
            //获取值并输出
            System.out.println("Actually ：FINAL_VALUE = "
                    + son.getFinalValue1());
        }

        System.out.println("将赋值放在三目表达式中后反射修改私有常量值 \n");
        if (finalField2 != null) {

            //获取私有常量的访问权
            finalField2.setAccessible(true);

            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改前的值
            System.out.println("Before Modify：FINAL_VALUE = "
                    + finalField2.get(son));

            //修改私有常量
            finalField2.set(son, "Modified");

            //调用 finalField 的 getter 方法
            //输出 FINAL_VALUE 修改后的值
            System.out.println("After Modify：FINAL_VALUE = "
                    + finalField2.get(son));

            //使用对象调用类的 getter 方法
            //获取值并输出
            System.out.println("Actually ：FINAL_VALUE = "
                    + son.getFinalValue2());
        }
    }
}
