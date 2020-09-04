package demo.reflect.CallClassMethods;

import demo.reflect.Son;

import java.lang.reflect.Field;

/**
 * Created by bear on 2020/9/4
 * 为简洁代码，在方法上抛出总的异常，实际开发别这样
 */
public class modifyPrivateFiled {

    public static void main(String[] args) throws Exception {

        Son son = new Son();

        // 第一步:获取类类型
        Class sonClass = son.getClass();

        //2. 获取私有变量
        Field privateField = sonClass.getDeclaredField("MSG");

        //3. 操作私有变量
        if (privateField != null) {
            //获取私有变量的访问权
            privateField.setAccessible(true);

            //修改私有变量，并输出以测试
            System.out.println("Before Modify：MSG = " + son.getMSG());

            //调用 set(object , value) 修改变量的值
            //privateField 是获取到的私有变量
            //son 要操作的对象
            //"Modified" 为要修改成的值
            privateField.set(son, "Modified");
            System.out.println(" After Modify：MSG = " + son.getMSG());
        }
    }
}
